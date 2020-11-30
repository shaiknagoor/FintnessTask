package com.androiddevs.mvvmnewsapp.api


import com.live.fintnesstask.models.ServerResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiCall {
companion object{
   val BaseURL="http://13.232.62.239/talzo/dummy/test/"
    //http://13.232.62.239/talzo/dummy/test/testing_data
}
    @GET("testing_data")
    suspend fun getTestData(
    ):Response<ServerResponse>

}