package com.aalsamarin.tasktracker.mapper

import com.aalsamarin.tasktracker.dto.TaskDto
import com.aalsamarin.tasktracker.entity.Project
import com.aalsamarin.tasktracker.entity.Task
import org.springframework.stereotype.Component

@Component
class TaskMapperImpl : TaskMapper {

    override fun toDto(entity: Task): TaskDto =
        TaskDto(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            status = entity.status,
            priority = entity.priority,
            projectId = entity.project.id,
        )

    override fun toEntity(dto: TaskDto, projectEntity: Project): Task =
        Task(
            id = dto.id,
            name = dto.name,
            description = dto.description,
            status = dto.status,
            priority = dto.priority,
            project = projectEntity,
        )
}
