package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) = userRepository.saveName(saveParam = param)

}