package com.nithin.feature.user.domain.usecase

import com.nithin.core.result.AppResult
import com.nithin.feature.user.domain.model.User
import com.nithin.feature.user.domain.repository.UserRepository

class GetAllUsersUseCase(
    private val repository: UserRepository
) {

    suspend fun invoke(): AppResult<List<User>> {
        return repository.getAllUsers()
    }

}