package com.aalsamarin.tasktracker.entity

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "task")
class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var name: String,
    var description: String,
    @Enumerated(value = EnumType.STRING)
    var status: Status = Status.ToDo,
    var priority: Int,
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    var project: Project,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Task) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun toString(): String {
        return "Task(id=$id, name='$name', project=$project)"
    }


    enum class Status {
        ToDo, InProgress, Done
    }
}
