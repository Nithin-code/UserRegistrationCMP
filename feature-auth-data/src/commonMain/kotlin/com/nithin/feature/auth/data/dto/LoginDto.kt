package com.nithin.feature.auth.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginDto(
    val id: String,
    val email: String,
    val password: String,
    @SerialName("created_at")
    val created_at: String,
)