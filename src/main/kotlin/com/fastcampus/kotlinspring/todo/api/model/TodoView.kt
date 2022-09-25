package com.fastcampus.kotlinspring.todo.api.model

import com.fastcampus.kotlinspring.todo.domain.Todo
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime

data class TodoListResponse(
    val items: List<TodoResponse>
) {
    val size: Int
        @JsonIgnore
        get() = items.size

    fun get(index: Int) = items[index]

    companion object {
        fun of(todoList: List<Todo>) =
            TodoListResponse(
                todoList.map(TodoResponse::of)
            )
    }
}

data class TodoRequest(
    val title: String,
    val description: String,
    val done: Boolean = false
)

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String,
    val done: Boolean,
    val createAt: LocalDateTime,
    val updatedAt: LocalDateTime?
) {
    companion object {
        fun of(todo: Todo?): TodoResponse {
            checkNotNull(todo) { "Todo is null" }

            return TodoResponse(
                id = todo.id,
                title = todo.title,
                description = todo.description,
                done = todo.done,
                createAt = todo.createAt,
                updatedAt = todo.updateAt
            )
        }

    }
}
