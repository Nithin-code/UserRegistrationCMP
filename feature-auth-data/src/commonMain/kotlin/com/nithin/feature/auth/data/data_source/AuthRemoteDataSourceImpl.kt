package com.nithin.feature.auth.data.data_source

import com.nithin.core.network.client.SupabaseClient
import com.nithin.feature.auth.data.dto.LoginDto
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

class AuthRemoteDataSourceImpl: AuthRemoteDataSource {
    override suspend fun login(email: String): LoginDto? {
        return SupabaseClient.client.from("login")
            .select(
                columns = Columns.list("id","email","password","created_at")
            ){
                filter { eq("email", email) }
            }
            .decodeSingleOrNull<LoginDto>()
    }
}