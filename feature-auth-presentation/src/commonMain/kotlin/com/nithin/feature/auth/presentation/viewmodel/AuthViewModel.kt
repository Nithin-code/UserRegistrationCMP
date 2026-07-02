package com.nithin.feature.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nithin.core.result.AppResult
import com.nithin.feature.auth.domain.use_case.LoginUseCase
import com.nithin.feature.auth.presentation.effects.LoginUiEffect
import com.nithin.feature.auth.presentation.effects.LoginUiEvent
import com.nithin.feature.auth.presentation.state.LoginUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val useCase: LoginUseCase
) : ViewModel() {

    private val _loginUIState = MutableStateFlow(LoginUiState())
    val loginUiState = _loginUIState.asStateFlow()

    private val _loginUIEffect = MutableSharedFlow<LoginUiEffect>()
    val loginUiEffect = _loginUIEffect.asSharedFlow()


    fun onEvent(event: LoginUiEvent){
        when(event){
            is LoginUiEvent.OnEmailChanged -> {
                _loginUIState.update {
                    it.copy(email = event.email)
                }
            }
            LoginUiEvent.OnLoginClicked -> {
                startLogin()
            }
            is LoginUiEvent.OnPasswordChanged -> {
                _loginUIState.update {
                    it.copy(password = event.password)
                }
            }
        }
    }

    private fun startLogin() {
        viewModelScope.launch {

            _loginUIState.update {
                it.copy(isLoading = true)
            }

            val result = useCase.invoke(_loginUIState.value.email, _loginUIState.value.password)

            when(result){
                is AppResult.Error -> {
                    _loginUIEffect.emit(
                        value = LoginUiEffect.ShowToast(message = result.message)
                    )
                }
                AppResult.Loading -> Unit
                is AppResult.Success<*> -> {
                    _loginUIEffect.emit(
                        value = LoginUiEffect.NavigateToHome
                    )
                }

            }

            _loginUIState.update {
                it.copy(isLoading = false)
            }

        }
    }

}