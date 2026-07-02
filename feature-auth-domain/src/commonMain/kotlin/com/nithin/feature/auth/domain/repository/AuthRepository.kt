package com.nithin.feature.auth.domain.repository

import com.nithin.core.result.AppResult
import com.nithin.feature.auth.domain.model.LoginUser

interface AuthRepository {
    suspend fun login(email: String, password: String) : LoginUser?
}