package com.nithin.feature.auth.presentation.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.nithin.feature.auth.presentation.viewmodel.AuthViewModel
import org.koin.dsl.module

val authPresentationModule = module {
    single { AuthViewModel(get()) }
}