package com.jetbrains.handson.handson.init

import kotlinx.serialization.Serializable

@Serializable
data class Configuration(val title: String, val projectName: String, val pathHandsOn: String, val pathProject: String)