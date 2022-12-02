package com.aalsamarin.tasktracker.dto

import com.aalsamarin.tasktracker.entity.Task

data class TaskDto(
    val id: Int,
    val name: String,
    val description: String,
    val status: Task.Status,
    val priority: Int,
    val projectId: Int,
)