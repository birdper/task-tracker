package com.aalsamarin.tasktracker.service.impl

import com.aalsamarin.tasktracker.dto.ProjectDto
import com.aalsamarin.tasktracker.exception.ProjectNotFound
import com.aalsamarin.tasktracker.mapper.ProjectMapper
import com.aalsamarin.tasktracker.mapper.TaskMapper
import com.aalsamarin.tasktracker.repository.ProjectRepository
import com.aalsamarin.tasktracker.repository.TaskRepository
import com.aalsamarin.tasktracker.service.ProjectService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProjectServiceImpl(
    val projectRepository: ProjectRepository,
    val taskRepository: TaskRepository,
    val projectMapper: ProjectMapper,
    val taskMapper: TaskMapper,
) : ProjectService {

    override fun getAllProjects(): List<ProjectDto> =
        projectRepository.findAll().map(projectMapper::toDto)

    override fun getById(id: Int): ProjectDto =
        projectRepository.findByIdOrNull(id)
            ?.let(projectMapper::toDto)
            ?: throw ProjectNotFound(id)

    @Transactional
    override fun create(dto: ProjectDto): Int {
        val project = projectRepository.save(projectMapper.toEntity(dto))

        val tasks = dto.tasks.map { taskMapper.toEntity(it, project) }
        taskRepository.saveAll(tasks)

        return project.id
    }

    @Transactional
    override fun update(id: Int, dto: ProjectDto) {
        val existingProject = projectRepository.findByIdOrNull(id)
            ?: throw ProjectNotFound(id)

        existingProject.status = dto.status
        existingProject.priority = dto.priority
        existingProject.startDate = dto.startDate
        existingProject.completionDate = dto.completionDate

        val tasks = dto.tasks.map { taskMapper.toEntity(it, existingProject) }
        taskRepository.deleteAllByProject(existingProject)
        taskRepository.saveAll(tasks)
    }

    @Transactional
    override fun deleteById(id: Int) {
        val existingProject = projectRepository.findByIdOrNull(id)
            ?: throw ProjectNotFound(id)

        taskRepository.deleteAllByProject(existingProject)
        projectRepository.deleteById(id)
    }
}
