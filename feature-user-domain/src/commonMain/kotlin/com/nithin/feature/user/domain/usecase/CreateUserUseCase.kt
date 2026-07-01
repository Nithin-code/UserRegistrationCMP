package com.nithin.feature.user.domain.usecase

import com.nithin.core.result.AppResult
import com.nithin.feature.user.domain.model.User
import com.nithin.feature.user.domain.repository.UserRepository

class CreateUserUseCase(
    private val repository: UserRepository
) {

    suspend fun invoke(user: User): AppResult<User> {
        return repository.insertUser(user)
    }

}