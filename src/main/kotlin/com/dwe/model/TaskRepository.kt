package com.dwe.model

object TaskRepository {
    private val tasks = mutableListOf(
        Task(
            name = "cleaning",
            description = "Clean the house",
            priority = Priority.Low
        ),
        Task(
            name = "gardening",
            description = "Mow the lawn",
            priority = Priority.Medium
        ),
        Task(
            name = "shopping",
            description = "Buy the groceries",
            priority = Priority.High
        ),
        Task(
            name = "painting",
            description = "Paint the fence",
            priority = Priority.Medium
        ),
    )

    fun allTasks(): List<Task> = tasks

    fun tasksByPriority(priority: Priority) = tasks.filter {
        it.priority == priority
    }

    fun taskByName(name: String) = tasks.find {
        it.name.equals(name, ignoreCase = true)
    }

    fun addTask(task: Task) {
        if (taskByName(task.name) != null) {
            throw IllegalArgumentException("Cannot duplicate task names!")
        }
        tasks.add(task)
    }

    fun removeTAsk(name: String): Boolean {
        return tasks.removeIf {it.name == name}
    }

}