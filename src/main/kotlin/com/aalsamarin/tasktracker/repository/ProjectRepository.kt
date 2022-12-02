package com.aalsamarin.tasktracker.repository

import com.aalsamarin.tasktracker.entity.Project
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository : PagingAndSortingRepository<Project, Int> {
}
