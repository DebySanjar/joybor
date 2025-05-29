package com.mrs.joybor.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrs.joybor.R
import com.mrs.joybor.databinding.ItemRoomBinding
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
        holder.binding.textName.text = item.name
        holder.binding.textAddress.text = item.address


        val imageUrl = item.images.firstOrNull()?.image
        Glide.with(holder.binding.imageLogo.context)
            .load(imageUrl)
            .placeholder(R.drawable.img)
            .into(holder.binding.imageLogo)

    }

    fun updateList(newList: List<RoomItem>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}
