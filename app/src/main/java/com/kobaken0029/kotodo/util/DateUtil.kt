package com.kobaken0029.kotodo.util

import org.threeten.bp.LocalDateTime

object DateUtil {
    fun now(): String {
        return LocalDateTime.now().toString()
    }
}
