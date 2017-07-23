package com.kobaken0029.kotodo.util

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

object DateUtil {
    fun now(): String {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"))
    }
}
