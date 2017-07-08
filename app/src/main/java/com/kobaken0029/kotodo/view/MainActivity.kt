package com.kobaken0029.kotodo.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kobaken0029.kotodo.R
import com.kobaken0029.kotodo.databinding.ActivityMainBinding
import com.kobaken0029.kotodo.model.Todo
import com.kobaken0029.kotodo.view.adapter.TodoAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = TodoAdapter(applicationContext, listOf(Todo("hoge"), Todo("piyo")))
        binding.todoList.adapter = adapter

        binding.todo = Todo("")
    }
}
