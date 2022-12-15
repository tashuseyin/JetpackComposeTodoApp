package com.example.jetpackcompose_todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcompose_todoapp.data.model.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}