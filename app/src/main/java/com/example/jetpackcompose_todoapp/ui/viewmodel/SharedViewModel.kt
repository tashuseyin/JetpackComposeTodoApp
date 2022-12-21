package com.example.jetpackcompose_todoapp.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose_todoapp.data.model.TodoTask
import com.example.jetpackcompose_todoapp.data.repository.TodoRepository
import com.example.jetpackcompose_todoapp.ui.list_screen.state.SearchBarState
import com.example.jetpackcompose_todoapp.util.RequestState
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


    private val _allTaskList: MutableStateFlow<RequestState<List<TodoTask>>> =
        MutableStateFlow(RequestState.Loading)
    val allTaskList: StateFlow<RequestState<List<TodoTask>>> = _allTaskList


    fun getAllTasks() {
        _allTaskList.value = RequestState.Loading
        try {
            viewModelScope.launch {
                todoRepository.getAllTasks.collect { taskList ->
                    _allTaskList.value = RequestState.Success(taskList)
                }
            }
        } catch (e: Exception) {
            _allTaskList.value = RequestState.Error(e)
        }
    }
}