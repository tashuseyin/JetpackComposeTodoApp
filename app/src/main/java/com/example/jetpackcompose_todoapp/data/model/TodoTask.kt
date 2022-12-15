package com.example.jetpackcompose_todoapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jetpackcompose_todoapp.util.Constants

@Entity(tableName = Constants.DATABASE_TABLE_NAME)
data class TodoTask(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)

