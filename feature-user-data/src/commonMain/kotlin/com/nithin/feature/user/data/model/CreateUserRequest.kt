package com.nithin.feature.user.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val name: String,
    val email: String,
    @SerialName("is_admin")
    val isAdmin: Boolean
)
