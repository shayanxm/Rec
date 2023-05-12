package com.example.rec.retrofit

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Object is Singleton
 */
object RetrofitClient {

fun getInstance():Retrofit{
    var mHttpLogginInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    var mOkHttpClient= OkHttpClient
        .Builder()
        .addInterceptor(mHttpLogginInterceptor)
        .build()

    var retrofit: Retrofit= retrofit2.Retrofit.Builder()
        .baseUrl("http:reqres.in")
        .addConverterFactory(GsonConverterFactory.create())
        .client(mOkHttpClient)
        .build()
    return retrofit
}

}