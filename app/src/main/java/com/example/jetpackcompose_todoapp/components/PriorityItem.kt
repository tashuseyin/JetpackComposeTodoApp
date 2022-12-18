package com.example.jetpackcompose_todoapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose_todoapp.data.model.Priority
import com.example.jetpackcompose_todoapp.ui.theme.LARGE_PADDING
import com.example.jetpackcompose_todoapp.ui.theme.PRIORITY_INDICATOR_SIZE
import com.example.jetpackcompose_todoapp.ui.theme.Typography

@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
        }
        Text(
            text = priority.name,
            modifier = Modifier.padding(start = LARGE_PADDING ),
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}


@Composable
@Preview(showBackground = true)
fun PriorityItemPreview() {
    PriorityItem(priority = Priority.HIGH)
}