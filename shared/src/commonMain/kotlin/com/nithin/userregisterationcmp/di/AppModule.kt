package com.nithin.userregisterationcmp.di

import com.nithin.feature.user.data.di.dataModule
import com.nithin.feature.user.domain.di.domainModule
import com.nithin.feature.user.presentation.di.presentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration


object KoinInitializerWrapper{
    fun initKoin(config: KoinAppDeclaration? = null) {
        startKoin {
            config?.invoke(this)
            modules( dataModule, domainModule, presentationModule)
        }
    }
}