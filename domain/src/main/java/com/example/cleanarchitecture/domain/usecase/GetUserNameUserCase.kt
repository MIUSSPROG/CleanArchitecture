package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUserCase(private val userRepository: UserRepository) {

    fun execute(): UserName = userRepository.getName()
}