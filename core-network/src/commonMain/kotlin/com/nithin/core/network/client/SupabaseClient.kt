package com.nithin.core.network.client

import com.nithin.core.network.config.SupabaseConfig
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = SupabaseConfig.URL,
        supabaseKey = SupabaseConfig.ANON_KEY
    ) {
        install(Auth)
        install(Postgrest)
    }
}