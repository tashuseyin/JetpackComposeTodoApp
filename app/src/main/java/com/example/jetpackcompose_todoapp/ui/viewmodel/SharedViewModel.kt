package com.example.jetpackcompose_todoapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose_todoapp.data.model.TodoTask
import com.example.jetpackcompose_todoapp.data.repository.TodoRepository
import com.example.jetpackcompose_todoapp.ui.list_screen.state.SearchBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val searchAppBarState: MutableState<SearchBarState> = mutableStateOf(SearchBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")


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