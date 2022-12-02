package com.aalsamarin.tasktracker.mapper

import com.aalsamarin.tasktracker.dto.ProjectDto
import com.aalsamarin.tasktracker.entity.Project

interface ProjectMapper {

    fun toDto(entity: Project): ProjectDto
    fun toEntity(dto: ProjectDto): Project
}