package com.mftadik.artbooktesting.repository

import androidx.lifecycle.LiveData
import com.mftadik.artbooktesting.model.ImageResponse
import com.mftadik.artbooktesting.roomdb.Art
import com.mftadik.artbooktesting.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art : Art)
    suspend fun deleteArt(art: Art)
    fun getArt() : LiveData<List<Art>>
    suspend fun searchImage(imageString : String) : Resource<ImageResponse>
}