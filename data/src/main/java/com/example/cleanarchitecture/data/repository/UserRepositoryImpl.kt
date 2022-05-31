package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository{

    override fun saveName(saveParam: SaveUserNameParam): Boolean{

        val user = mapToStorage(saveParam)

        return userStorage.save(user)
    }

    override fun getName(): UserName{

        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstname = user.firstName, lastName = user.lastName)
    }
}