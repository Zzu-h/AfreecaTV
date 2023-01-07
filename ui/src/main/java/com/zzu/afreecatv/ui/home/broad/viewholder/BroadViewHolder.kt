package com.zzu.afreecatv.ui.home.broad.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.zzu.afreecatv.databinding.ItemBroadBinding
import com.zzu.afreecatv.domain.model.Broad

class BroadViewHolder(private val binding: ItemBroadBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Broad) {
        binding.item = item
    }
}