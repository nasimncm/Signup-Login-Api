package com.example.turegunew.api

import com.example.turegunew.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @POST("auth/register")
    fun createUser(
        @Body createUser: Register
    ): Call<RegisterResponse>

    @POST("auth/login")
    fun loginUser(
        @Body userLogin: UserLogin
    ): Call<LoginResponse>

    @POST("auth/password/forgot")
    fun forgotPassword(
        @Body forgotPassword: ForgotPasswordReset
    ): Call<RegisterResponse>

    @POST("/auth/password/change")
    fun changePassword(
        @Body changePassword: ChangePasswordReset
    ): Call<RegisterResponse>

    @GET("property/list")
    fun propertyList(): Call<PropertyModel>

    @GET("property/favourite/list")
    fun saveProducts(@Header("token") token: String): Call<Favoriot>

    @GET("user/agent/list")
    fun agents(): Call<Agents>

    @GET("auth/profile")
    fun profile(@Header("token") token: String): Call<ProfileModel>
}