package com.example.pradeshadvkotlin.model.response.register


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @Expose
    @SerializedName("access_token")
    val accessToken: String,
    @Expose
    @SerializedName("token_type")
    val tokenType: String,
    @Expose
    @SerializedName("user")
    val user: User
)