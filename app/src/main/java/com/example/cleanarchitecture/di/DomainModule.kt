package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.repository.UserRepository
import com.example.cleanarchitecture.domain.usecase.GetUserNameUserCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

//    @Provides
//    fun provideGetUserNameUserCase(userRepository: UserRepository): GetUserNameUserCase{
//        return GetUserNameUserCase(userRepository = userRepository)
//    }
//
//    @Provides
//    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase{
//        return SaveUserNameUseCase(userRepository = userRepository)
//    }

}