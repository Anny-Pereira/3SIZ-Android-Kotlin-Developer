package br.com.annypereira.apptask.features.task.data.local.repository

import br.com.annypereira.apptask.features.task.data.local.dao.TaskDao
import br.com.annypereira.apptask.features.task.data.local.entity.Task

class TaskRepository(
    private val dao: TaskDao
) {
    val tasks = dao.getAll()
    suspend fun insert(task: Task) {
        dao.insert(task)
    }
    suspend fun delete(task: Task) {
        dao.delete(task)
    }
    suspend fun clearAll() {
        dao.clearAll()
    }
}