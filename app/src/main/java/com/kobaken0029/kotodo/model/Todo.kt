package com.kobaken0029.kotodo.model

data class Todo(val content: String) {
    fun create() {
        TODO("作成します")
    }

    fun delete() {
        TODO("削除します")
    }
}
