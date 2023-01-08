package com.zzu.afreecatv.ui.home.broad.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.zzu.afreecatv.databinding.ItemBroadBinding
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.ui.home.broad.adapter.BroadRVAdapter

class BroadViewHolder(private val binding: ItemBroadBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Broad, listener: BroadRVAdapter.OnClickListener) {
        binding.item = item
        binding.listener = listener
    }
}