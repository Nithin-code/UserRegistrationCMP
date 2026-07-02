package com.nithin.feature.auth.data.di

import com.nithin.feature.auth.data.data_source.AuthRemoteDataSource
import com.nithin.feature.auth.data.data_source.AuthRemoteDataSourceImpl
import com.nithin.feature.auth.data.repository.AuthRepositoryImpl
import com.nithin.feature.auth.domain.repository.AuthRepository
import org.koin.dsl.module

val authDataModule = module {
    single<AuthRemoteDataSource> { AuthRemoteDataSourceImpl() }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}