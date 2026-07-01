package com.nithin.feature.user.presentation.event

sealed interface UserEvent {

    data class CreateUser(
        val name: String,
        val email: String,
        val isAdmin: Boolean
    ) : UserEvent

    data object LoadUsers : UserEvent
}