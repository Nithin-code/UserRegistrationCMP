package com.nithin.feature.auth.presentation.effects

sealed interface LoginUiEvent {
    data class OnEmailChanged(val email: String) : LoginUiEvent
    data class OnPasswordChanged(val password: String) : LoginUiEvent
    data object OnLoginClicked : LoginUiEvent
}