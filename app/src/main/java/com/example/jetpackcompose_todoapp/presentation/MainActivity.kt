package com.example.jetpackcompose_todoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose_todoapp.navigaiton.SetupNavigationComponent
import com.example.jetpackcompose_todoapp.ui.theme.JetpackComposeTodoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTodoAppTheme {
                navController = rememberNavController()
                SetupNavigationComponent(navController = navController)
            }
        }
    }
}