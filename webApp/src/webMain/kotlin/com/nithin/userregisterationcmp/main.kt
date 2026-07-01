package com.nithin.userregisterationcmp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.nithin.userregisterationcmp.di.KoinInitializerWrapper

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    KoinInitializerWrapper.initKoin()
    ComposeViewport {
        App()
    }
}