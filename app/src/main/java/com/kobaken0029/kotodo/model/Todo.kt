package com.kobaken0029.kotodo.model

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import io.soramitsu.irohaandroid.security.MessageDigest

data class Todo(val content: String) {
    fun create(): Boolean {
        if (validate()) {
            val key = MessageDigest.digest(content, MessageDigest.Algorithm.SHA3_256)
            val database = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference(key)
            myRef.setValue(content)
            return true
        }
        return false
    }

    fun delete(): Boolean {
        TODO("削除します")
    }

    private fun validate() = !content.isBlank()
}
