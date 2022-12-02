package com.aalsamarin.tasktracker.dto

import com.aalsamarin.tasktracker.entity.Project
import java.time.LocalDateTime

data class ProjectDto(
    val id: Int,
    val name: String,
    var startDate: LocalDateTime,
    var completionDate: LocalDateTime,
    var status: Project.Status,
    var priority: Int,
    var tasks: List<TaskDto> = emptyList(),
)
