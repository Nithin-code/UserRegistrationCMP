package com.nithin.feature.user.presentation.event

sealed interface UiEffects {
    data class ShowToast(val message: String): UiEffects
}