package com.nithin.feature.auth.data.repository

import com.nithin.core.result.AppResult
import com.nithin.feature.auth.data.data_source.AuthRemoteDataSource
import com.nithin.feature.auth.data.mappers.toLoginUser
import com.nithin.feature.auth.domain.model.LoginUser
import com.nithin.feature.auth.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val dataSource: AuthRemoteDataSource
): AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): LoginUser? {
        return dataSource.login(email)?.toLoginUser()
    }

}