package com.nithin.feature.user.domain.model

data class User(
    val id: Long = 0,
    val name: String,
    val email: String,
    val phone: String,
    val address: String
)