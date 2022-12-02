package com.aalsamarin.tasktracker.service.impl

import com.aalsamarin.tasktracker.dto.TaskDto
import com.aalsamarin.tasktracker.exception.ProjectNotFound
import com.aalsamarin.tasktracker.exception.TaskNotFound
import com.aalsamarin.tasktracker.mapper.TaskMapper
import com.aalsamarin.tasktracker.repository.ProjectRepository
import com.aalsamarin.tasktracker.repository.TaskRepository
import com.aalsamarin.tasktracker.service.TaskService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskServiceImpl(
    private val taskRepository: TaskRepository,
    private val projectRepository: ProjectRepository,
    private val taskMapper: TaskMapper,
) : TaskService {

    override fun getAllTasks(projectId: Int): List<TaskDto>  {
        val project = projectRepository.findByIdOrNull(projectId)
            ?: throw ProjectNotFound(projectId)

        return project.tasks.map(taskMapper::toDto)
    }

    override fun getById(id: Int): TaskDto =
        taskRepository.findByIdOrNull(id)
            ?. let(taskMapper::toDto)
            ?: throw TaskNotFound(id)

    @Transactional
    override fun create(taskDto: TaskDto): Int {
        val existingProject = projectRepository.findByIdOrNull(taskDto.projectId)
            ?: throw ProjectNotFound(taskDto.projectId)

        val task = taskMapper.toEntity(taskDto, existingProject)

        existingProject.addTask(task)
        taskRepository.save(task)

        return task.id
    }

    @Transactional
    override fun update(id: Int, dto: TaskDto) {
        val existingTask = taskRepository.findByIdOrNull(id)
            ?: throw TaskNotFound(id)

        val project = projectRepository.findByIdOrNull(dto.projectId)
            ?: throw ProjectNotFound(dto.projectId)

        existingTask.project = project
        existingTask.name = dto.name
        existingTask.description = dto.description
        existingTask.status = dto.status
        existingTask.priority = dto.priority

        taskRepository.save(existingTask)
    }

    override fun deleteById(id: Int) {
        taskRepository.findByIdOrNull(id)
            ?: throw TaskNotFound(id)

        taskRepository.deleteById(id)
    }
}
