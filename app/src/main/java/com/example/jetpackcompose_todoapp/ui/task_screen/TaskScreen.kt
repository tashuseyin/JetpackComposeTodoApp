package com.example.jetpackcompose_todoapp.ui.task_screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose_todoapp.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit
) {

    Scaffold(
        topBar = {
            TaskTopAppBar(navigateToListScreen = navigateToListScreen)
        },
        content = {}
    )
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TaskScreenPreview() {
    TaskScreen(navigateToListScreen = {})
}