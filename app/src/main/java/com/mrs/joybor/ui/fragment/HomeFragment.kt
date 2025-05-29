package com.mrs.joybor.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mrs.joybor.databinding.FragmentHomeBinding
import com.mrs.joybor.models.RoomItem
import com.mrs.joybor.ui.adapters.HomeAdapter
import com.mrs.joybor.utils.Status
import com.mrs.joybor.vm.RoomViewModel


@Suppress("UNCHECKED_CAST")
class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"

    lateinit var binding: FragmentHomeBinding
    lateinit var roomViewModel: RoomViewModel
    lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeAdapter(emptyList())
        binding.homeRecy.adapter = adapter

        roomViewModel = ViewModelProvider(this)[RoomViewModel::class.java]

        roomViewModel.fetchRooms()

        roomViewModel.fetchRooms().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.ERROR -> {

                }

                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    adapter.updateList(it.body as List<RoomItem>)
                    Log.d(TAG, "onViewCreated:  it.body = ${it.body}")
                }
            }

        }


    }
}