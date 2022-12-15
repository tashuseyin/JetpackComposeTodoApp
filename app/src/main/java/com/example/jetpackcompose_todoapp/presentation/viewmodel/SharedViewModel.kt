package com.example.jetpackcompose_todoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose_todoapp.data.model.TodoTask
import com.example.jetpackcompose_todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _allTaskList: MutableStateFlow<List<TodoTask>> = MutableStateFlow(emptyList())
    val allTaskList: StateFlow<List<TodoTask>> = _allTaskList


    fun getAllTasks() {
        viewModelScope.launch {
            todoRepository.getAllTasks.collect { taskList ->
                _allTaskList.value = taskList
            }
        }
    }
}