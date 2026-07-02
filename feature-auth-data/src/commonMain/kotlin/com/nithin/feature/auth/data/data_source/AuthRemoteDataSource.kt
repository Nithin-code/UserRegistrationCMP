package com.nithin.feature.auth.data.data_source

import com.nithin.feature.auth.data.dto.LoginDto

interface AuthRemoteDataSource {
    suspend fun login(email: String): LoginDto?
}