package com.nithin.feature.auth.data.mappers

import com.nithin.feature.auth.data.dto.LoginDto
import com.nithin.feature.auth.domain.model.LoginUser

fun LoginDto.toLoginUser() = LoginUser(
    email = email,
    password = password
)