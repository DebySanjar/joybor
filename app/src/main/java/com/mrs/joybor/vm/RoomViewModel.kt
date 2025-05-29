package com.mrs.joybor.vm

import androidx.lifecycle.*
import com.mrs.joybor.repository.RoomRepository
import com.mrs.joybor.utils.Recourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class RoomViewModel : ViewModel() {

    private val repository = RoomRepository()

    private val liveList = MutableLiveData<Recourse<Any>>()


    fun fetchRooms(): MutableLiveData<Recourse<Any>> {
        viewModelScope.launch(Dispatchers.IO) {

            liveList.postValue(Recourse.loading())

            try {
                val todos = repository.getRooms()
                liveList.postValue(Recourse.success(todos))
            } catch (e: Exception) {
                liveList.postValue(Recourse.error(e.message))
            } finally {

            }
        }

        return liveList

    }
}

