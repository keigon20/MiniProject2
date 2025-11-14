package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.data.local.DatabaseModule
import com.example.myapplication.data.remote.RetrofitModule
import com.example.myapplication.data.repository.UserRepository

object AppModule {

    fun provideUserRepository(context: Context): UserRepository {
        val db = DatabaseModule.provideDatabase(context)
        val api = RetrofitModule.api
        return UserRepository(api, db.userDao())
    }
}
