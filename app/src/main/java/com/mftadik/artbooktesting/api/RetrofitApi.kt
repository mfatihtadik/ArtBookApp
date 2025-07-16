package com.mftadik.artbooktesting.api

import com.mftadik.artbooktesting.model.ImageResponse
import com.mftadik.artbooktesting.util.Util.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("/api/")
    suspend fun imageSearch(
          @Query("q") searchQuery : String,
          @Query("key") apiKey : String = API_KEY
    ) : retrofit2.Response<ImageResponse>

}