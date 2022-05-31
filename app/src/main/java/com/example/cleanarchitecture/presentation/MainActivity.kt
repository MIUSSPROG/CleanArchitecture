package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.app.App
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.sharedprefs.SharedPrefsUserStorage
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.usecase.GetUserNameUserCase
import com.example.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel
    @Inject
    lateinit var vmFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, )
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity cleared")

        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

        vm.resultLiveData.observe(this){
            binding.dataTextView.text = it
        }

        binding.sendButton.setOnClickListener{
            val text = binding.dataEditText.text.toString()
            vm.save(text)
        }

        binding.receiveButton.setOnClickListener {
            vm.load()
        }
    }
}