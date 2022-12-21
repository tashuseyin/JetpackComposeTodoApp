package com.example.jetpackcompose_todoapp.util


sealed class RequestState<out T> {
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error<T>(val message: Throwable) : RequestState<T>()
    object Loading : RequestState<Nothing>()
}