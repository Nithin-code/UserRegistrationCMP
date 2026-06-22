package com.nithin.userregisterationcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform