package com.kobaken0029.kotodo.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.kobaken0029.kotodo.R
import com.kobaken0029.kotodo.databinding.ActivityMainBinding
import com.kobaken0029.kotodo.model.Todo
import com.kobaken0029.kotodo.util.DateUtil.now
import com.kobaken0029.kotodo.view.adapter.TodoAdapter

class MainActivity : AppCompatActivity(), MainViewHandler {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TodoAdapter

    private lateinit var firebaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        firebaseReference = FirebaseDatabase.getInstance().reference.child("messages")

        adapter = TodoAdapter(this, firebaseReference)
        binding.todoList.adapter = adapter

        binding.handler = this
    }

    override fun createTodo() {
        val content = binding.todoEdit.text.toString()
        if (!content.isBlank()) {
            val todo = Todo(content, false, now(), now())
            adapter.add(todo)
            Toast.makeText(applicationContext, "${todo.content}を追加しました", Toast.LENGTH_SHORT).show()
            binding.todoEdit.setText("")
        } else {
            Toast.makeText(applicationContext, "入力してください", Toast.LENGTH_SHORT).show()
        }
    }
}
