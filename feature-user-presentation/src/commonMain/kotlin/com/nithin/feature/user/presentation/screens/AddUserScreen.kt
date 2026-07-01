package com.nithin.feature.user.presentation.screens

import  androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.nithin.feature.user.presentation.event.UiEffects
import com.nithin.feature.user.presentation.event.UserEvent
import com.nithin.feature.user.presentation.view_model.UserViewModel
import kotlinx.coroutines.flow.forEach
import org.koin.compose.koinInject

@Composable
fun AddUserScreen(
    viewModel : UserViewModel = koinInject()
){
    val uiState by viewModel.uiState.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }
    var userName by remember {
        mutableStateOf("")
    }
    var userEmail by remember {
        mutableStateOf("")
    }
    var isAdmin by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit){
        viewModel.uiEffects.collect { effects->
            when(effects){
                is UiEffects.ShowToast -> {
                    snackBarHostState.showSnackbar(
                        message = effects.message
                    )
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        modifier = Modifier.fillMaxSize()
    ){ paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 24.dp)
            .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            OutlinedTextField(
                value = userName,
                onValueChange = {
                    userName = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("User Name") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = userEmail,
                onValueChange = {
                    userEmail = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("User Email") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = isAdmin,
                onValueChange = {
                    isAdmin = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Is Admin") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        defaultKeyboardAction(imeAction = ImeAction.Done)
                    }
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.onEvent(UserEvent.CreateUser(
                        name = userName,
                        email = userEmail,
                        isAdmin = isAdmin.equals("true", ignoreCase = true)
                    ))
                },
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Add User")
            }

        }
    }

}