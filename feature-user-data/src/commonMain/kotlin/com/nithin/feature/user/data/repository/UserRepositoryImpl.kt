package com.nithin.feature.user.data.repository

import com.nithin.core.result.AppResult
import com.nithin.feature.user.data.data_sourece.UserRemoteDataSource
import com.nithin.feature.user.data.mapper.toUser
import com.nithin.feature.user.data.mapper.toUserDto
import com.nithin.feature.user.domain.model.User
import com.nithin.feature.user.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource
): UserRepository {
    override suspend fun insertUser(user: User): AppResult<User> {
        return try {
            userRemoteDataSource.createUser(user.toUserDto())
            AppResult.Success(user)
        } catch (e: Throwable) {
            AppResult.Error(e.message ?: "Unknown error occurred")
        }
    }

    override suspend fun getAllUsers(): AppResult<List<User>> {
        return try {
            val users = userRemoteDataSource.getAllUsers().map { it.toUser() }
            AppResult.Success(users)
        }catch (t : Throwable){
            AppResult.Error(t.message ?: "Unknown error occurred")
        }
    }
}