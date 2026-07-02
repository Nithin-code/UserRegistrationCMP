package com.nithin.feature.auth.presentation.effects

sealed interface LoginUiEffect {

    data class ShowToast(val message: String) : LoginUiEffect

    data object NavigateToHome : LoginUiEffect

}