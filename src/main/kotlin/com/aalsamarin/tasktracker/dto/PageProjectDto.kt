package com.aalsamarin.tasktracker.dto

data class PageProjectDto(
    val currentPage: Int,
    val totalPages: Int,
    val projects: List<ProjectDto>,
)