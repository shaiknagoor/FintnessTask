package com.live.fintnesstask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.live.fintnesstask.models.ServerResponse
import com.live.fintnesstask.repository.FitRepository
import com.live.fintnesstask.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class FitViewmodel(val fitRepository: FitRepository): ViewModel() {
    val testDatalist:MutableLiveData<Resource<ServerResponse>> = MutableLiveData()

    init {
        getTestData()
    }

     fun getTestData() {
        viewModelScope.launch {
            testDatalist.postValue(Resource.Loading())
        val response= fitRepository.getTestResData()
            testDatalist.postValue(handlingResponse(response))

        }
    }

    private fun handlingResponse(response: Response<ServerResponse>): Resource<ServerResponse>? {
   if(response.isSuccessful){
       response.body()?.let {
        return  Resource.Success(it)
       }
   }
        return Resource.Error(response.message())
    }
}