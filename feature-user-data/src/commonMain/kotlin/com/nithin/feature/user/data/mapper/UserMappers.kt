package com.nithin.feature.user.data.mapper

import com.nithin.feature.user.data.dto.UserDto
import com.nithin.feature.user.domain.model.User

fun UserDto.toUser(): User {
    return User(
        id = "",
        name = name,
        email = email,
        isAdmin = isAdmin,
        createdAt = ""
    )
}

fun User.toUserDto() = UserDto(
    name = name,
    email = email,
    isAdmin = isAdmin,
)