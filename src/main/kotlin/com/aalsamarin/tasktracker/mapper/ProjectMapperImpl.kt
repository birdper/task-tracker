package com.aalsamarin.tasktracker.mapper

import com.aalsamarin.tasktracker.dto.ProjectDto
import com.aalsamarin.tasktracker.entity.Project
import org.springframework.stereotype.Component

@Component
class ProjectMapperImpl(private val taskMapper: TaskMapper) : ProjectMapper {

    override fun toDto(entity: Project): ProjectDto =
        ProjectDto(
            id = entity.id,
            name = entity.name,
            startDate = entity.startDate,
            completionDate = entity.completionDate,
            status = entity.status,
            priority = entity.priority,
            tasks = entity.tasks.map(taskMapper::toDto),
        )

    override fun toEntity(dto: ProjectDto) =
        Project(
            id = dto.id,
            name = dto.name,
            startDate = dto.startDate,
            completionDate = dto.completionDate,
            status = dto.status,
            priority = dto.priority,
        )
}