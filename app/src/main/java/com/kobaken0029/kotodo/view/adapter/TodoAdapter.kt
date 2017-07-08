package com.kobaken0029.kotodo.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.kobaken0029.kotodo.R
import com.kobaken0029.kotodo.databinding.ItemTodoBinding
import com.kobaken0029.kotodo.model.Todo

class TodoAdapter(context: Context, items: List<Todo>)
    : ArrayAdapter<Todo>(context, R.layout.item_todo, items) {

    val ctx = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return convertView?.apply {
            val binding = DataBindingUtil.getBinding<ItemTodoBinding>(this)
            bindTodo(binding, getItem(position))
        } ?: let {
            val binding = ItemTodoBinding.inflate(LayoutInflater.from(ctx), parent, false)
            bindTodo(binding, getItem(position))
            return binding.root
        }
    }

    private fun bindTodo(binding: ItemTodoBinding, todo: Todo) {
        binding.todo = todo
    }
}
