package com.example.cleanarchitecture.di

import android.content.Context
import androidx.core.content.contentValuesOf
import com.example.cleanarchitecture.domain.usecase.GetUserNameUserCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchitecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context{
        return context
    }

//    @Provides
//    fun provideMainViewModelFactory(
//        getUserNameUserCase: GetUserNameUserCase,
//        saveUserNameUseCase: SaveUserNameUseCase
//    ): MainViewModelFactory{
//        return MainViewModelFactory(getUserNameUseCase = getUserNameUserCase, saveUsernameUseCase = saveUserNameUseCase)
//    }
}