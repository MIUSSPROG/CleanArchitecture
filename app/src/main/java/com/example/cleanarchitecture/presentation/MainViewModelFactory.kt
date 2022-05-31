package com.example.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleanarchitecture.domain.usecase.GetUserNameUserCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context = context)) }
    private val getUserNameUseCase by lazy { GetUserNameUserCase(userRepository = userRepository) }
    private val saveUsernameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUsernameUseCase = saveUsernameUseCase
        ) as T
    }
}