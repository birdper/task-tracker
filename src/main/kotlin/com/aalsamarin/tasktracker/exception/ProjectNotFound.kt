package com.aalsamarin.tasktracker.exception

import org.springframework.http.HttpStatus

class ProjectNotFound(projectId: Int) : BaseException(
    httpStatus = HttpStatus.NOT_FOUND,
    apiError = ApiError(
        errorCode = 404,
        description = "Project not found with id=$projectId",
    )
)
