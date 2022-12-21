package com.example.jetpackcompose_todoapp.ui.task_screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.jetpackcompose_todoapp.data.model.Priority
import com.example.jetpackcompose_todoapp.data.model.TodoTask
import com.example.jetpackcompose_todoapp.ui.viewmodel.SharedViewModel
import com.example.jetpackcompose_todoapp.util.Action

@Composable
fun TaskScreen(
    selectedTask: TodoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskTopAppBar(selectedTask = selectedTask, navigateToListScreen = navigateToListScreen)
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.title.value = it
                },
                description = description,
                onDescriptionChange = {
                    sharedViewModel.description.value = it
                },
                priority = priority,
                onPrioritySelect = {
                    sharedViewModel.priority.value = it
                }
            )
        }
    )
}
