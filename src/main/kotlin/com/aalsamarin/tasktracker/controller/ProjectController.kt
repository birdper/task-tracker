package com.aalsamarin.tasktracker.controller

import com.aalsamarin.tasktracker.dto.ProjectDto
import com.aalsamarin.tasktracker.service.ProjectService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/projects")
class ProjectController(
    val projectService: ProjectService
) {

    @GetMapping
    fun getAllProjects(): List<ProjectDto> =
        projectService.getAllProjects()

    @GetMapping("{id}")
    fun getProjectById(@PathVariable id: Int): ProjectDto =
        projectService.getById(id)

    @PostMapping
    fun createProject(@RequestBody dto: ProjectDto): Int =
        projectService.create(dto)

    @PutMapping("/{id}")
    fun updateProject(@PathVariable id: Int, @RequestBody dto: ProjectDto) {
        projectService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deleteProject(@PathVariable id: Int) {
        projectService.deleteById(id)
    }
}
