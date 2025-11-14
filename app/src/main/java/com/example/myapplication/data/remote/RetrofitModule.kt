package com.example.myapplication.data.remote

object RetrofitModule {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: UserApi = retrofit2.Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
        .build()
        .create(UserApi::class.java)
}
