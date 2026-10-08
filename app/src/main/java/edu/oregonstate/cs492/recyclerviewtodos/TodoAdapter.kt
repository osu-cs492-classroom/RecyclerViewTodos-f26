package edu.oregonstate.cs492.recyclerviewtodos

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter : RecyclerView.Adapter<>() {
    val todos = mutableListOf<Todo>()

    fun addTodo(todo: Todo) {
        todos.add(0, todo)
        notifyItemInserted(0)
    }

    override fun getItemCount() = todos.size

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val checkbox = view.findViewById<CheckBox>(R.id.todo_checkbox)
        private val todoTextTV = view.findViewById<TextView>(R.id.tv_todo_text)
        private var currentTodo: Todo? = null

        fun bind(todo: Todo) {
            checkbox.isChecked = todo.completed
            todoTextTV.text = todo.text
            currentTodo = todo
        }
    }
}