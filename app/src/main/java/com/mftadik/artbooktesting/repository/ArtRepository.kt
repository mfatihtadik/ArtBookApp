package com.mftadik.artbooktesting.repository

import android.widget.Toast
import androidx.lifecycle.LiveData
import com.mftadik.artbooktesting.api.RetrofitApi
import com.mftadik.artbooktesting.model.ImageResponse
import com.mftadik.artbooktesting.roomdb.Art
import com.mftadik.artbooktesting.roomdb.ArtDao
import com.mftadik.artbooktesting.util.Resource
import javax.inject.Inject

class ArtRepository @Inject constructor(private val artDao : ArtDao, private val retrofitApi : RetrofitApi) : ArtRepositoryInterface {

    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }
    override suspend fun deleteArt(art: Art) {
        artDao.deleteArt(art)
    }
    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArt()
    }
    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response = retrofitApi.imageSearch(imageString)
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            } else {
                Resource.error("Error", null)
            }

        } catch (e: Exception){
            Resource.error("No data!", null)
        }
    }
}