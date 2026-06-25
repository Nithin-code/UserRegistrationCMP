package com.nithin.feature.user.data.data_sourece

import com.nithin.feature.user.data.dto.UserDto

interface UserRemoteDataSource{
    suspend fun createUser(userDto: UserDto)
    suspend fun getAllUsers(): List<UserDto>
}