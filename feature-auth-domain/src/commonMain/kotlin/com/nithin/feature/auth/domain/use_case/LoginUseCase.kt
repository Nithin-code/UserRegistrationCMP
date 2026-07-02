package com.nithin.feature.auth.domain.use_case

import com.nithin.core.result.AppResult
import com.nithin.feature.auth.domain.model.LoginUser
import com.nithin.feature.auth.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend fun invoke(email: String, password: String) : AppResult<LoginUser> {

        if (email.isEmpty()) return AppResult.Error("Please Enter Email")

        if (password.isEmpty()) return AppResult.Error("Please Enter Password")

        return try {

            val user = repository.login(email, password)

            when {
                user == null -> {
                    AppResult.Error("User Not Found")
                }
                user.password != password -> {
                    AppResult.Error("Incorrect Password")
                }
                else -> {
                    AppResult.Success(data = user)
                }
            }
        }catch (t: Exception){
            AppResult.Error("Failed With Error: ${t.message}")
        }
    }
}