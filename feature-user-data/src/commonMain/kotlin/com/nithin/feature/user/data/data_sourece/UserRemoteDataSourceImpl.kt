package com.nithin.feature.user.data.data_sourece

import com.nithin.core.network.client.SupabaseClient
import com.nithin.feature.user.data.dto.UserDto
import com.nithin.feature.user.data.model.CreateUserRequest
import io.github.jan.supabase.postgrest.from

class UserRemoteDataSourceImpl : UserRemoteDataSource {
    override suspend fun createUser(
        userDto: UserDto
    ) {
        try {
            println("Inserting user: $userDto")
            SupabaseClient
                .client.from("users")
                .insert(
                    CreateUserRequest(
                        name = userDto.name,
                        email = userDto.email,
                        isAdmin = userDto.isAdmin
                    )
                )
            println("Insert completed successfully")
        }catch (t: Throwable){
            println("error is ${t.message}")
            throw t
        }
    }

    override suspend fun getAllUsers(): List<UserDto> {
        return SupabaseClient
            .client.from("users")
            .select()
            .decodeList<UserDto>()
    }
}