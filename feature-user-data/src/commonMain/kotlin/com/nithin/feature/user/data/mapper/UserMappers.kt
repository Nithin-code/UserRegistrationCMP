package com.nithin.feature.user.data.mapper

import com.nithin.feature.user.data.dto.UserDto
import com.nithin.feature.user.domain.model.User

fun UserDto.toUser(): User {
    return User(
        id = id,
        name = name,
        email = email,
        isAdmin = isAdmin,
        createdAt = createdAt
    )
}

fun User.toUserDto() = UserDto(
    id = id,
    name = name,
    email = email,
    isAdmin = isAdmin,
    createdAt = createdAt
)