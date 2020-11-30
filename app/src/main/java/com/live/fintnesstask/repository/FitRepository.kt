package com.live.fintnesstask.repository

import android.content.Context
import com.androiddevs.mvvmnewsapp.api.ApiClient

class FitRepository(context: Context) {
  suspend  fun getTestResData()=
        ApiClient.api.getTestData()

}