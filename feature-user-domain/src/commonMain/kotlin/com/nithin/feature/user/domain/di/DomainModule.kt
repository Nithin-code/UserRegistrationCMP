package com.nithin.feature.user.domain.di

import com.nithin.feature.user.domain.usecase.CreateUserUseCase
import com.nithin.feature.user.domain.usecase.GetAllUsersUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        CreateUserUseCase(get())
    }

    factory {
        GetAllUsersUseCase(get())
    }

}