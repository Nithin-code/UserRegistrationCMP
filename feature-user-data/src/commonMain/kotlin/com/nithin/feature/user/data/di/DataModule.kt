package com.nithin.feature.user.data.di

import com.nithin.feature.user.data.data_sourece.UserRemoteDataSource
import com.nithin.feature.user.data.data_sourece.UserRemoteDataSourceImpl
import com.nithin.feature.user.data.repository.UserRepositoryImpl
import com.nithin.feature.user.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserRemoteDataSource> { UserRemoteDataSourceImpl() }
    single<UserRepository> { UserRepositoryImpl(get()) }
}