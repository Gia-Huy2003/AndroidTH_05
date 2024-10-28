package com.example.bai3122

import retrofit2.http.GET


interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}