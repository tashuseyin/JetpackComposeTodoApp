package com.example.jetpackcompose_todoapp.data.repository

import com.example.jetpackcompose_todoapp.data.local.TodoDao
import com.example.jetpackcompose_todoapp.data.model.TodoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val getAllTasks: Flow<List<TodoTask>> = todoDao.getAllTask()
    val sortByLowPriority: Flow<List<TodoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TodoTask> {
        return todoDao.getSelectedTask(taskId)
    }

    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>> {
        return todoDao.searchDatabase(searchQuery)
    }

    suspend fun addTask(todoTask: TodoTask) {
        todoDao.addTask(todoTask)
    }

    suspend fun updateTask(todoTask: TodoTask) {
        todoDao.updateTask(todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTask) {
        todoDao.deleteTask(todoTask)
    }

    suspend fun deleteAllTask() {
        todoDao.deleteAllTasks()
    }
}