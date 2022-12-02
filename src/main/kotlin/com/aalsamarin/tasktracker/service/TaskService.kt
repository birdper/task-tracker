package com.aalsamarin.tasktracker.service

import com.aalsamarin.tasktracker.dto.TaskDto

interface TaskService {

    fun getAllTasks(projectId: Int): List<TaskDto>
    fun getById(id: Int): TaskDto
    fun create(taskDto: TaskDto): Int
    fun update(id: Int, dto: TaskDto)
    fun deleteById(id: Int)
}