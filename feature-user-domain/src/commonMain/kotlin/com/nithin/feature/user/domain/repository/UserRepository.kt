package com.nithin.feature.user.domain.repository

import com.nithin.core.result.AppResult
import com.nithin.feature.user.domain.model.User

interface UserRepository {
    suspend fun insertUser(user: User): AppResult<User>
    suspend fun getAllUsers(): AppResult<List<User>>
}