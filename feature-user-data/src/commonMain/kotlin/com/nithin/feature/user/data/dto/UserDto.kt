package com.nithin.feature.user.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val name: String,
    val email: String,
    @SerialName("is_admin")
    val isAdmin: Boolean
)