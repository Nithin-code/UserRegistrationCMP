package com.nithin.feature.auth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.core.constants.Constants
import com.nithin.feature.auth.presentation.effects.LoginUiEffect
import com.nithin.feature.auth.presentation.effects.LoginUiEvent
import com.nithin.feature.auth.presentation.viewmodel.AuthViewModel
import org.koin.compose.koinInject

@Composable
fun LoginScreenRoute(
    viewModel: AuthViewModel = koinInject(),
    onSuccess : ()-> Unit
){

    val state by viewModel.loginUiState.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit){
        viewModel.loginUiEffect.collect { effect ->
            when(effect){
                LoginUiEffect.NavigateToHome -> {
                    onSuccess.invoke()
                }
                is LoginUiEffect.ShowToast -> {
                    snackbarHostState.showSnackbar(message = effect.message)
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF5F5F5))
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Login",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 120.dp),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = state.email,
                onValueChange = {
                    viewModel.onEvent(LoginUiEvent.OnEmailChanged(it))
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("E-mail", color = Color(0xFF1E293B)) },
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(LoginUiEvent.OnPasswordChanged(it))
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Password", color = Color(0xFF1E293B)) },
                supportingText = {
                    Text(
                        text = if (state.isIncorrectPassword) Constants.INCORRECT_PASSWORD_TEXT else "",
                        color = if (state.isIncorrectPassword) Color(0XFFD12E34) else Color.Transparent,
                        fontSize = 14.sp
                    )
                },
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = Constants.FORGOT_PASSWORD,
                    color = Color(0xFF3C9AFB),
                    textAlign = TextAlign.End,
                    textDecoration = TextDecoration.Underline,
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Button(
                modifier = Modifier.height(44.dp).fillMaxWidth(),
                onClick = {
                    viewModel.onEvent(LoginUiEvent.OnLoginClicked)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2B8761),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(50)
            ){
                Text(
                    text = "Login",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "or login with",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(22.dp))



        }

    }

}