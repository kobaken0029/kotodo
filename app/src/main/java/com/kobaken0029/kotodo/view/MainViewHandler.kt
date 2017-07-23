package com.kobaken0029.kotodo.view

interface MainViewHandler {
    fun createTodo()
    fun deleteTodo(key: String): Boolean
}
