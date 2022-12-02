package com.aalsamarin.tasktracker.exception

import org.springframework.http.HttpStatus

class TaskNotFound(taskId: Int) : BaseException(
    httpStatus = HttpStatus.NOT_FOUND,
    apiError = ApiError(
        errorCode = 404,
        description = "Task not found with id=$taskId",
    )
)