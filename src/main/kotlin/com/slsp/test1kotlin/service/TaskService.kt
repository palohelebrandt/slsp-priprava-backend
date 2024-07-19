package com.slsp.test1kotlin.service

import com.slsp.test1kotlin.repository.TaskRepository
import com.slsp.test1kotlin.task.Task
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun getAllTasks(): Flux<Task> = taskRepository.findAll()
    fun getTaskById(id: Long): Mono<Task> = taskRepository.findById(id)
    fun createTask(task: Task): Mono<Task> = taskRepository.save(task)
    fun updateTask(id: Long, task: Task): Mono<Task> =
        taskRepository.findById(id)
            .flatMap { existingTask ->
                val updatedTask = existingTask.copy(name = task.name, completed = task.completed)
                taskRepository.save(updatedTask)
            }
    fun deleteTask(id: Long): Mono<Void> = taskRepository.deleteById(id)
}
