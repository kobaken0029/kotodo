package com.kobaken0029.kotodo.model

data class Todo(
        val content: String,
        val done: Boolean,
        val createdAt: String,
        val updatedAt: String) {

    constructor() : this("", false, "", "")
}
