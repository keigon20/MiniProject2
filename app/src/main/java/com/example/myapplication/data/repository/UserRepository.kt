package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.UserApi
import com.example.myapplication.data.local.UserDao
import com.example.myapplication.data.local.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val api: UserApi,
    private val dao: UserDao
) {

    val users: Flow<List<UserEntity>> = dao.getUsers()

    suspend fun refreshUsers() {
        try {
            val remoteUsers = api.getUsers()

            val entities = remoteUsers.map {
                UserEntity(
                    id = it.id,
                    name = it.name,
                    email = it.email,
                    phone = it.phone
                )
            }

            dao.insertUsers(entities)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun searchUsers(query: String): Flow<List<UserEntity>> {
        return dao.searchUsers(query)
    }
}
