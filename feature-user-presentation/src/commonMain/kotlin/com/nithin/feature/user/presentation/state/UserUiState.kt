package com.nithin.feature.user.presentation.state

import com.nithin.feature.user.domain.model.User

data class UserUiState (
    val users: List<User> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)