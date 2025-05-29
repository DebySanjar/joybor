package com.mrs.joybor.models


data class RoomItem(
    val id: Int,
    val university: University,
    val admin: UserItem,
    val name: String,
    val address: String,
    val description: String?,
    val photo: String?
)
