package com.example.jetpackcompose_todoapp.data.model

import androidx.compose.ui.graphics.Color
import com.example.jetpackcompose_todoapp.ui.theme.HighPriorityColor
import com.example.jetpackcompose_todoapp.ui.theme.LowPriorityColor
import com.example.jetpackcompose_todoapp.ui.theme.MediumPriorityColor
import com.example.jetpackcompose_todoapp.ui.theme.NonePriorityColor

enum class Priority(val color: Color){
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}