package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUserCase @Inject constructor(val userRepository: UserRepository) {

    fun execute(): UserName = userRepository.getName()
}