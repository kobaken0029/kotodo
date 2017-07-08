package com.kobaken0029.kotodo.view

import com.kobaken0029.kotodo.model.Todo

interface TodoHandler {
    fun deleteTodo(todo: Todo)
}