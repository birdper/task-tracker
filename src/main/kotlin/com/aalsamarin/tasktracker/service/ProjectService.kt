package com.aalsamarin.tasktracker.service

import com.aalsamarin.tasktracker.dto.ProjectDto

interface ProjectService {

    fun getAllProjects(): List<ProjectDto>
    fun getById(id: Int): ProjectDto
    fun create(dto: ProjectDto): Int
    fun update(id: Int, dto: ProjectDto)
    fun deleteById(id: Int)
}