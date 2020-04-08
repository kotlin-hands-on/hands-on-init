package com.jetbrains.handson.handson.init

import kotlin.system.exitProcess


fun hello(): String = "Hello, Kotlin/Native!"

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("\n usage: hands-on-init {config.json}")
        exitProcess(-1)
    }

    val configurationFile = ConfigurationFile()
    try {
        val config = configurationFile.load(args[0])
        val handsOnInitiator = HandsOnInitiator(config)
        handsOnInitiator.createFolderStructure()
        handsOnInitiator.createMarkdownFiles()
        handsOnInitiator.createLicenseFile()
        handsOnInitiator.createGitIngoreFile()
        handsOnInitiator.outputInstructions()
    } catch (e: Exception) {
        printErrorMessage(e)
        exitProcess(-1)
    }
}

fun printErrorMessage(e: Throwable) {
    println("\n An error occurred: ${e.message}")
}