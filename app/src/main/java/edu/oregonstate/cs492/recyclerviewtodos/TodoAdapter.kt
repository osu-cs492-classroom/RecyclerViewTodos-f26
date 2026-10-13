package edu.oregonstate.cs492.recyclerviewtodos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    val todos = mutableListOf<Todo>()

    fun addTodo(todo: Todo) {
        todos.add(0, todo)
        notifyItemInserted(0)
    }

    fun deleteTodo(position: Int) {
        todos.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount() = todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val checkbox = view.findViewById<CheckBox>(R.id.todo_checkbox)
        private val todoTextTV = view.findViewById<TextView>(R.id.tv_todo_text)
        private var currentTodo: Todo? = null

        init {
            checkbox.setOnCheckedChangeListener { _, isChecked -> currentTodo?.completed = isChecked }
        }

        fun bind(todo: Todo) {
            checkbox.isChecked = todo.completed
            todoTextTV.text = todo.text
            currentTodo = todo
        }
    }
}