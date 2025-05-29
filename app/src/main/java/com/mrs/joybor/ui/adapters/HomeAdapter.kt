package com.mrs.joybor.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrs.joybor.models.RoomItem


class HomeAdapter(private var list: List<RoomItem>) :
    RecyclerView.Adapter<HomeAdapter.RoomViewHolder>() {

    inner class RoomViewHolder(val binding: ItemRoomBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = ItemRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            textName.text = item.name
            textAddress.text = item.address
            Glide.with(imageLogo.context)
                .load(item.university.logo)
                .into(imageLogo)
        }
    }

    override fun getItemCount(): Int = list.size
}
