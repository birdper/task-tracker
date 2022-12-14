package com.aalsamarin.tasktracker.service

import com.aalsamarin.tasktracker.dto.PageProjectDto
import com.aalsamarin.tasktracker.dto.ProjectDto
import org.springframework.data.domain.Pageable

interface ProjectService {

    fun getAllProjects(): List<ProjectDto>
    fun getPageProjects(pageable: Pageable): PageProjectDto
    fun getById(id: Int): ProjectDto
    fun create(dto: ProjectDto): Int
    fun update(id: Int, dto: ProjectDto)
    fun deleteById(id: Int)
}