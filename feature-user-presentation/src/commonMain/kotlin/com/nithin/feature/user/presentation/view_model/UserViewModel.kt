package com.nithin.feature.user.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.core.result.AppResult
import com.nithin.feature.user.domain.model.User
import com.nithin.feature.user.domain.usecase.CreateUserUseCase
import com.nithin.feature.user.domain.usecase.GetAllUsersUseCase
import com.nithin.feature.user.presentation.event.UiEffects
import com.nithin.feature.user.presentation.event.UserEvent
import com.nithin.feature.user.presentation.state.UserUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getAllUserUseCase: GetAllUsersUseCase
) : ViewModel(){

    private val _uiState = MutableStateFlow(UserUiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEffects = MutableSharedFlow<UiEffects>()
    val uiEffects = _uiEffects.asSharedFlow()

    fun onEvent(event: UserEvent) {
        when(event){
            is UserEvent.CreateUser -> {
                createUser(
                    name = event.name,
                    email = event.email,
                    isAdmin = event.isAdmin
                )
            }
            UserEvent.LoadUsers -> {

            }
        }
    }

    private fun createUser(
        name: String,
        email: String,
        isAdmin: Boolean
    ){
        viewModelScope.launch {

            val user = User(
                id = "",
                name = name,
                email = email,
                isAdmin = isAdmin,
                createdAt = ""
            )

            println("user is $user")

            when(val result = createUserUseCase.invoke(user)){
                is AppResult.Error -> {
                    _uiEffects.emit(
                        value = UiEffects.ShowToast(result.message)
                    )
                    println("error is ${result.message}")
                }
                AppResult.Loading -> {
                    println("loading")
                }
                is AppResult.Success<*> -> {
                    _uiEffects.emit(
                        value = UiEffects.ShowToast("User Data Created Successfully...")
                    )
                    println("Success")
                }
            }

        }
    }

}