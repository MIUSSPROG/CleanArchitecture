package com.example.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleanarchitecture.domain.usecase.GetUserNameUserCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val getUserNameUseCase: GetUserNameUserCase,
    private val saveUsernameUseCase: SaveUserNameUseCase): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUsernameUseCase = saveUsernameUseCase
        ) as T
    }
}