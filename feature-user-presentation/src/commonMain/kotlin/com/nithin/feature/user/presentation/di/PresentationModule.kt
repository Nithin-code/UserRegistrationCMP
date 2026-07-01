package com.nithin.feature.user.presentation.di

import com.nithin.feature.user.presentation.view_model.UserViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory {
        UserViewModel(
            get(),
            get()
        )
    }
}