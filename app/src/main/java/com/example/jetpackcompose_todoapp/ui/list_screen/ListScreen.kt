package com.example.jetpackcompose_todoapp.ui.list_screen

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.jetpackcompose_todoapp.R
import com.example.jetpackcompose_todoapp.ui.theme.fabBackgroundColor
import com.example.jetpackcompose_todoapp.ui.viewmodel.SharedViewModel
import com.example.jetpackcompose_todoapp.ui.list_screen.state.SearchBarState

@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    val searchBarState: SearchBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListScreenTopAppBar(
                searchBarState = searchBarState,
                searchTextState = searchTextState,
                sharedViewModel = sharedViewModel
            )
        },
        content = {

        },
        floatingActionButton = {
            ListScreenFAB(onFabClicked = navigateToTaskScreen)
        }
    )
}

@Composable
fun ListScreenFAB(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_task),
            tint = Color.White
        )

    }
}