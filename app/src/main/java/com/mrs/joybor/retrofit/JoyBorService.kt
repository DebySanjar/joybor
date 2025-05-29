package com.mrs.joybor.retrofit

import com.mrs.joybor.models.RoomItem
import retrofit2.http.GET

interface JoyBorService {

    @GET("dormitories/")
    suspend fun getRooms(): List<RoomItem>
}