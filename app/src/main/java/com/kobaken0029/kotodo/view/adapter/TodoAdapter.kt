package com.kobaken0029.kotodo.view.adapter

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.firebase.ui.database.FirebaseListAdapter
import com.google.firebase.database.DatabaseReference
import com.kobaken0029.kotodo.R
import com.kobaken0029.kotodo.model.Todo
import com.kobaken0029.kotodo.util.DateUtil.now
import com.kobaken0029.kotodo.view.MainViewHandler

class TodoAdapter(context: Activity, val viewHandler: MainViewHandler, val reference: DatabaseReference)
    : FirebaseListAdapter<Todo>(context, Todo::class.java, R.layout.item_todo, reference) {

    override fun populateView(v: View, todo: Todo, position: Int) {
        val contentView = v.findViewById(R.id.content) as TextView
        contentView.text = todo.content
        val updatedAtView = v.findViewById(R.id.updated_at) as TextView
        updatedAtView.text = todo.updatedAt
        with(v.findViewById(R.id.done) as CheckBox) {
            isChecked = todo.done
            setOnClickListener { done(todo, getRef(position).key) }
        }
        with(v) {
            setBackgroundColor(if (todo.done) Color.LTGRAY else Color.WHITE)
            setOnLongClickListener { viewHandler.deleteTodo(getRef(position).key) }
        }
    }

    fun add(todo: Todo) {
        reference.push().setValue(todo)
    }

    fun done(todo: Todo, targetKey: String) {
        val target = reference.child(targetKey)
        target.child("done").setValue(!todo.done)
        target.child("updatedAt").setValue(now())
    }

    fun remove(targetKey: String): Boolean {
        reference.child(targetKey).removeValue()
        return true
    }
}
