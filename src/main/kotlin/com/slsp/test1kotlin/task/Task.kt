package com.slsp.test1kotlin.task

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("tasks")
data class Task(
    @Id val id: Long? = null,
    val name: String,
    val completed: Boolean
)