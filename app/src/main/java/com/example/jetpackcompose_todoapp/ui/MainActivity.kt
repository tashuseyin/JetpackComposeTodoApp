package com.example.jetpackcompose_todoapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose_todoapp.navigaiton.SetupNavigationComponent
import com.example.jetpackcompose_todoapp.ui.theme.JetpackComposeTodoAppTheme
import com.example.jetpackcompose_todoapp.ui.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTodoAppTheme {
                navController = rememberNavController()
                SetupNavigationComponent(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}