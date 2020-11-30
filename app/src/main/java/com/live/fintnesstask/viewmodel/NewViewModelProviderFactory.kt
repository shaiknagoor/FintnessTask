package com.androiddevs.mvvmnewsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.live.fintnesstask.repository.FitRepository
import com.live.fintnesstask.viewmodel.FitViewmodel

class NewViewModelProviderFactory (val fitRepository: FitRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return FitViewmodel(fitRepository) as T
    }

}