package com.slsp.test1kotlin.repository

import com.slsp.test1kotlin.task.Task
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface TaskRepository : ReactiveCrudRepository<Task, Long> {
    fun findByCompleted(completed: Boolean): Flux<Task>
}