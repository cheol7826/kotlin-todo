package com.fastcampus.kotlinspring.todo.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "title")
    var title: String,

    @Lob
    @Column(name = "description")
    var description: String,

    @Column(name = "done")
    var done: Boolean,

    @Column(name = "created_at")
    @CreatedDate
    var createAt: LocalDateTime,

    @Column(name = "updated_at")
    @LastModifiedDate
    var updateAt: LocalDateTime? = null
) {
    fun update(
        title: String,
        description: String,
        done: Boolean
    ) {
        this.title = title
        this.description = description
        this.done = done
        this.updateAt = LocalDateTime.now()
    }
}
