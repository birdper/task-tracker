package com.aalsamarin.tasktracker.controller

import com.aalsamarin.tasktracker.dto.TaskDto
import com.aalsamarin.tasktracker.service.TaskService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(
    val taskService: TaskService,
) {

    @GetMapping("projects{projectId}/tasks")
    fun getAllTask(@PathVariable projectId: Int): List<TaskDto> =
        taskService.getAllTasks(projectId)

    @GetMapping("/tasks/{id}")
    fun getTaskById(@PathVariable id: Int): TaskDto =
        taskService.getById(id)

    @PostMapping("/tasks")
    fun createTask(@RequestBody taskDto: TaskDto): Int =
        taskService.create(taskDto)

    @PostMapping("/tasks/{id}")
    fun updateTask(@PathVariable id: Int,
                   @RequestBody taskDto: TaskDto) {
        taskService.update(id, taskDto)
    }

    @DeleteMapping("/tasks/{id}")
    fun deleteTask(@PathVariable id: Int) {
        taskService.deleteById(id)
    }
}
