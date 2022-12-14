package com.aalsamarin.tasktracker.dto

import org.springframework.data.domain.Sort

enum class ProjectSort(
    val sortValue: Sort
) {
    ID_DESC(Sort.by(Sort.Direction.DESC, "id")),

    NAME_ASC(Sort.by(Sort.Direction.ASC, "name")),
    NAME_DESC(Sort.by(Sort.Direction.DESC, "name")),

    START_DATE_ASC(Sort.by(Sort.Direction.ASC, "startDate")),
    START_DATE_DESC(Sort.by(Sort.Direction.DESC, "startDate")),

    COMPLETION_DATE_ASC(Sort.by(Sort.Direction.ASC, "completionDate")),
    COMPLETION_DATE_DESC(Sort.by(Sort.Direction.DESC, "completionDate")),

    PRIORITY_ASC(Sort.by(Sort.Direction.ASC, "priority")),
    PRIORITY_DESC(Sort.by(Sort.Direction.DESC, "priority")),

    STATUS_ASC(Sort.by(Sort.Direction.ASC, "status")),
    STATUS_DESC(Sort.by(Sort.Direction.DESC, "status")),
}
