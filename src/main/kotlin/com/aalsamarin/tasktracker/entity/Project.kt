package com.aalsamarin.tasktracker.entity

import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "project")
class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var name: String = "",
    var startDate: LocalDateTime = LocalDateTime.now(),
    var completionDate: LocalDateTime,
    @Enumerated(value = EnumType.STRING)
    var status: Status = Status.NotStarted,
    var priority: Int,
    @OneToMany(mappedBy = "project", cascade = [CascadeType.ALL], orphanRemoval = true)
    var tasks: MutableList<Task> = mutableListOf(),
) {

    fun addTask(task: Task) {
        task.project = this
        tasks.add(task)
    }

    fun removeTask(task: Task) {
        tasks.remove(task)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Project) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun toString(): String {
        return "Project(id=$id, name='$name')"
    }


    enum class Status {
        NotStarted, Active, Completed
    }
}
