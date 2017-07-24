package com.kobaken0029.kotodo.util

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter.ofPattern

object DateUtil {
    fun now(): String = LocalDateTime.now().format(ofPattern("yyyy/MM/dd hh:mm:ss"))
}
