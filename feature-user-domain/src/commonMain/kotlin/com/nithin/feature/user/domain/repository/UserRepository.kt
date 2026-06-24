package com.nithin.feature.user.domain.repository

import com.nithin.core.result.NetworkResult
import com.nithin.feature.user.domain.model.User

interface UserRepository {
    suspend fun insertUser(user: User): NetworkResult<User>
    fun getAllUsers(): NetworkResult<List<User>>
}