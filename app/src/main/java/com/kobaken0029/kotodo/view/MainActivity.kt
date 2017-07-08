package com.kobaken0029.kotodo.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kobaken0029.kotodo.R
import com.kobaken0029.kotodo.databinding.ActivityMainBinding
import com.kobaken0029.kotodo.model.Todo
import com.kobaken0029.kotodo.view.adapter.TodoAdapter

class MainActivity : AppCompatActivity(), MainViewHandler, TodoHandler {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = TodoAdapter(applicationContext, this, listOf(Todo("hoge"), Todo("piyo")))
        binding.todoList.adapter = adapter

        binding.handler = this
    }

    override fun createTodo() {
        val todo: Todo = Todo(binding.todoEdit.text.toString())
        if (todo.create()) {
            Toast.makeText(applicationContext, "${todo.content}を追加しました", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "入力してください", Toast.LENGTH_SHORT).show()
        }
        binding.todoEdit.setText("")
    }

    override fun deleteTodo(todo: Todo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
