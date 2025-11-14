package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.di.AppModule
import com.example.myapplication.ui.users.UserListScreen
import com.example.myapplication.ui.users.UserViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<UserViewModel> {
        val repo = AppModule.provideUserRepository(applicationContext)

        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return UserViewModel(repo) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UserListScreen(viewModel)
        }
    }
}
