package com.example.jetpackcompose_todoapp.ui.task_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose_todoapp.R
import com.example.jetpackcompose_todoapp.components.PriorityDropDownMenu
import com.example.jetpackcompose_todoapp.data.model.Priority
import com.example.jetpackcompose_todoapp.ui.theme.LARGE_PADDING
import com.example.jetpackcompose_todoapp.ui.theme.MEDIUM_PADDING

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelect: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LARGE_PADDING)
            .background(MaterialTheme.colors.background)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(R.string.title)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier.padding(all = MEDIUM_PADDING),
            color = MaterialTheme.colors.background
        )
        PriorityDropDownMenu(priority = priority, onPrioritySelected = onPrioritySelect)
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = stringResource(R.string.description)) },
            textStyle = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TaskContentPreview() {
    TaskContent(
        title = "Title",
        onTitleChange = {},
        description = "Description",
        onDescriptionChange = {},
        priority = Priority.MEDIUM,
        onPrioritySelect = {}
    )
}
