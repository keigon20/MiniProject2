package com.example.myapplication.ui.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.local.UserEntity

@Composable
fun UserListScreen(viewModel: UserViewModel) {
    val users by viewModel.users.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = viewModel.searchQuery.collectAsState().value,
            onValueChange = { viewModel.searchQuery.value = it },
            label = { Text("Search users…") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(users) { user ->
                UserItem(user)
                Divider()
            }
        }
    }
}

@Composable
fun UserItem(user: UserEntity) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = user.name, style = MaterialTheme.typography.titleMedium)
        Text(text = user.email)
        Text(text = user.phone)
    }
}
