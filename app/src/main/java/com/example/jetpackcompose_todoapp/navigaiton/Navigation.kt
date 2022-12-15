package com.example.jetpackcompose_todoapp.navigaiton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.jetpackcompose_todoapp.navigaiton.destination.listComposable
import com.example.jetpackcompose_todoapp.navigaiton.destination.taskComposable
import com.example.jetpackcompose_todoapp.util.Constants


@Composable
fun SetupNavigationComponent(navController: NavHostController) {

    val screen = remember(navController) {
        NavigationScreens(navController = navController)
    }

    NavHost(navController = navController, startDestination = Constants.LIST_SCREEN) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }

}