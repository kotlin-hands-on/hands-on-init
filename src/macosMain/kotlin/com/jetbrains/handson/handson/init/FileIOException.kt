package com.jetbrains.handson.handson.init

import kotlinx.cinterop.toKString
import platform.posix.strerror

class FileIOException(errorCode: Int) : Throwable(strerror(errorCode)?.toKString() ?: "Error: $errorCode")
