package com.example.rec.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/api/user?page=2")
    suspend fun getallUsers() : Response<ResponseListUsers>
}