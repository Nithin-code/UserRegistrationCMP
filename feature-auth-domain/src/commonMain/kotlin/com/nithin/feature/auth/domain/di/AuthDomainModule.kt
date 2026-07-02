package com.nithin.feature.auth.domain.di

import com.nithin.feature.auth.domain.use_case.LoginUseCase
import org.koin.dsl.module

val authDomainModule = module {
    factory<LoginUseCase> { LoginUseCase(get()) }
}