package com.nithin.feature.auth.presentation.state

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading : Boolean = false,
    val isIncorrectPassword: Boolean = true,
)