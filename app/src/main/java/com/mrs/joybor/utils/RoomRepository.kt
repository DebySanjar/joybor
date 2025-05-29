package com.mrs.joybor.utils

import com.mrs.joybor.models.RoomItem
import com.mrs.joybor.retrofit.ApiClient


class RoomRepository {
    suspend fun getRooms(): List<RoomItem> {
        return ApiClient.api.getRooms()
    }
}
