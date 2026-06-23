package com.nithin.userregisterationcmp.network

import com.nithin.userregisterationcmp.config.SuprabaseConfig
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SuprabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = SuprabaseConfig.URL,
        supabaseKey = SuprabaseConfig.ANON_KEY
    ){
        install(Auth)
        install(Postgrest)
    }
}