package com.slsp.test1kotlin.controller

import com.slsp.test1kotlin.service.TaskService
import com.slsp.test1kotlin.task.Task
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTasks(): Flux<Task> = taskService.getAllTasks()

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): Mono<Task> = taskService.getTaskById(id)

    @PostMapping
    fun createTask(@RequestBody task: Task): Mono<Task> = taskService.createTask(task)

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody task: Task): Mono<Task> = taskService.updateTask(id, task)

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long): Mono<Void> = taskService.deleteTask(id)
}