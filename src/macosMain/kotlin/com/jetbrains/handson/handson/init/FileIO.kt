package com.jetbrains.handson.handson.init

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import platform.posix.*

class FileIO() {

    fun readFile(filename: String): String {
        val file = fopen(filename, "r")
            ?: throw FileIOException(errno)
        var contents = ""
        try {
            memScoped {
                val bufferLength = 64 * 1024
                val buffer = allocArray<ByteVar>(bufferLength)
                var nextLine = fgets(buffer, bufferLength, file)?.toKString()
                while (nextLine != null) {
                    contents += nextLine
                    nextLine = fgets(buffer, bufferLength, file)?.toKString()
                }
            }
        } finally{
            fclose(file)
        }
        return contents
    }

    fun createFolder(folderName: String) {
        val result = mkdir(folderName, S_IRWXU)
        if (result != 0 && result != -1) {
            throw FileIOException(errno)
        }
    }

    fun createFile(fileName: String, contents: String) {
        val file = fopen(fileName, "w") ?: throw FileIOException(errno)
        try {
            fprintf(file, contents)
        } finally {
            fclose(file)
        }
    }
}