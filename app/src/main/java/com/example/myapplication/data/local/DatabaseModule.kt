package com.example.myapplication.data.local

import android.content.Context
import androidx.room.Room

object DatabaseModule {
    fun provideDatabase(context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "user_db"
        ).build()
    }
}
