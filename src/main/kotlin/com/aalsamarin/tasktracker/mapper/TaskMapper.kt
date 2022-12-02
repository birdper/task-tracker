package com.aalsamarin.tasktracker.mapper

import com.aalsamarin.tasktracker.dto.TaskDto
import com.aalsamarin.tasktracker.entity.Project
import com.aalsamarin.tasktracker.entity.Task

interface TaskMapper {

    fun toDto(entity: Task): TaskDto
    fun toEntity(dto: TaskDto, projectEntity: Project): Task
}