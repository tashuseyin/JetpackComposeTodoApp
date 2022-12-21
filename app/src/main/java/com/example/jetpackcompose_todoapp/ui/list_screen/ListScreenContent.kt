package com.example.jetpackcompose_todoapp.ui.list_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose_todoapp.data.model.Priority
import com.example.jetpackcompose_todoapp.data.model.TodoTask
import com.example.jetpackcompose_todoapp.ui.theme.*
import com.example.jetpackcompose_todoapp.util.RequestState

@ExperimentalMaterialApi
@Composable
fun ListScreenContent(
    tasks: RequestState<List<TodoTask>>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (tasks is RequestState.Success) {
        if (tasks.data.isEmpty()) {
            EmptyContentDesign()
        } else {
            DisplayTasks(tasks = tasks.data , navigateToTaskScreen = navigateToTaskScreen)
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun TaskItem(
    todoTask: TodoTask,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = { navigateToTaskScreen(todoTask._id) }
    ) {
        Column(
            modifier = Modifier
                .padding(LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = todoTask.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .size(PRIORITY_INDICATOR_SIZE)
                    ) {
                        drawCircle(color = todoTask.priority.color)
                    }
                }
            }
            Text(
                text = todoTask.description,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun DisplayTasks(
    tasks: List<TodoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    LazyColumn {
        items(
            items = tasks,
            key = { task ->
                task._id
            }
        ) { task ->
            TaskItem(todoTask = task, navigateToTaskScreen = navigateToTaskScreen)
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
fun ListScreenContentPreview() {
    JetpackComposeTodoAppTheme(darkTheme = true) {
        TaskItem(
            todoTask = TodoTask(0, "Title", "Lorem ipsum description content text", Priority.HIGH),
            navigateToTaskScreen = {})
    }
}