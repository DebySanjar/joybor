package com.mrs.joybor.vm

import androidx.lifecycle.*
import com.mrs.joybor.models.RoomItem
import com.mrs.joybor.utils.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class RoomViewModel : ViewModel() {
    private val repository = RoomRepository()

    private val getR = MutableLiveData<List<RoomItem>>()
    val rooms: LiveData<List<RoomItem>> get() = getR

    fun fetchRooms() {
        viewModelScope.launch(Dispatchers.IO) {

            coroutineScope {
                try {
                    getR.value = repository.getRooms()
                } catch (e: Exception) {

                }
            }
        }
    }
}
