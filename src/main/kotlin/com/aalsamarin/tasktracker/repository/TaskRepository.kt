package com.aalsamarin.tasktracker.repository

import com.aalsamarin.tasktracker.entity.Project
import com.aalsamarin.tasktracker.entity.Task
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : PagingAndSortingRepository<Task, Int> {

    fun deleteAllByProject(project: Project)
}