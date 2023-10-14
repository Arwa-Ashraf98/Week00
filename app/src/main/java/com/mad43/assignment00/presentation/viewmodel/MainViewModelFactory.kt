package com.mad43.assignment00.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mad43.assignment00.domain.interactors.GetMobileTypeUseCase

@Suppress("UNCHECKED_CAST")
class MobileViewModelFactory(private val useCase: GetMobileTypeUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(useCase) as T
        } else  {
            throw java.lang.IllegalArgumentException("No ViewModel with the provided Data")
        }
    }
}

