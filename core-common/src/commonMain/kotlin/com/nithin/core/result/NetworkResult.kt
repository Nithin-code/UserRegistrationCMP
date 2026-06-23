package com.nithin.core.result

sealed interface NetworkResult<out T> {

    data object Loading: NetworkResult<Nothing>

    data class Success<T>(val data: T): NetworkResult<T>

    data class Error(val message: String): NetworkResult<Nothing>
}
