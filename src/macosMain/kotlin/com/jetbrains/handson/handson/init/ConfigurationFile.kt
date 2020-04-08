package com.jetbrains.handson.handson.init

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration


class ConfigurationFile {
    fun load(fileName: String): Configuration {
        val fileReader = FileIO()
        try {
            val contents = fileReader.readFile(fileName)
            val json = Json(JsonConfiguration.Default)
            return json.parse(Configuration.serializer(), contents)
        } catch (e: FileIOException) {
            throw ConfigurationException(e.message!!)
        }
    }

}


