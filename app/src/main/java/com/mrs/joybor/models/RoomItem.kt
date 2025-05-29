package com.mrs.joybor.models


data class RoomItem(
    val id: Int,
    val university: University,
    val admin: Admin,
    val name: String,
    val address: String,
    val description: String?,
    val images: List<DormitoryImageSafe>,
    val month_price: Double?,
    val year_price: Double?,
    val latitude: Double?,
    val longitude: Double?,
    val has_wifi: Boolean?,
    val has_library: Boolean?,
    val has_gym: Boolean?,
    val has_classroom: Boolean?,
    val total_capacity: String?,
    val available_capacity: String?,
    val total_rooms: String?
)
