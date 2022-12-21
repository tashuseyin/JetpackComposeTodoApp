package com.example.jetpackcompose_todoapp.navigaiton

import androidx.navigation.NavHostController
import com.example.jetpackcompose_todoapp.util.Action
import com.example.jetpackcompose_todoapp.util.Constants

class NavigationScreens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(Constants.LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}