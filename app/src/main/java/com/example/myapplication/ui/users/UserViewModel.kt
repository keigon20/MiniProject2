package com.example.myapplication.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import com.example.myapplication.data.repository.UserRepository

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val searchQuery = MutableStateFlow("")

    val users = searchQuery
        .debounce(200)
        .flatMapLatest { query ->
            if (query.isBlank()) {
                repository.users
            } else {
                repository.searchUsers(query)
            }
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        // Attempt API refresh; loads cached data immediately
        viewModelScope.launch {
            repository.refreshUsers()
        }
    }
}
