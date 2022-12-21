package com.example.jetpackcompose_todoapp.navigaiton.destination

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpackcompose_todoapp.ui.task_screen.TaskScreen
import com.example.jetpackcompose_todoapp.ui.viewmodel.SharedViewModel
import com.example.jetpackcompose_todoapp.util.Action
import com.example.jetpackcompose_todoapp.util.Constants
import com.example.jetpackcompose_todoapp.util.Constants.TASK_ARGUMENT_KEY

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = true){
            sharedViewModel.updateTaskFields(selectedTask = selectedTask)
        }

        TaskScreen(
            selectedTask = selectedTask,
            sharedViewModel = sharedViewModel,
            navigateToListScreen = navigateToListScreen
        )
    }
}