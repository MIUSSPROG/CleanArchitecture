package com.example.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.usecase.GetUserNameUserCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val saveUsernameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUserCase
): ViewModel() {


    private val _resultLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = _resultLiveData

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text: String){
        val params = SaveUserNameParam(name = text)
        val resultData = saveUsernameUseCase.execute(param = params)
        _resultLiveData.value = "Save result = $resultData"
    }

    fun load(){
        val userName = getUserNameUseCase.execute()
        _resultLiveData.value = "${userName.firstname} ${userName.lastName}"
    }
}