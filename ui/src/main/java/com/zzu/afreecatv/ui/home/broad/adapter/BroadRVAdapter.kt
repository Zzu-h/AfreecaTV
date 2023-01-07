package com.zzu.afreecatv.ui.home.broad.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.zzu.afreecatv.databinding.ItemBroadBinding
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.ui.home.broad.viewholder.BroadViewHolder

class BroadRVAdapter :
    ListAdapter<Broad, BroadViewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: BroadViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BroadViewHolder {
        return BroadViewHolder(
            ItemBroadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Broad>() {
            override fun areItemsTheSame(oldItem: Broad, newItem: Broad): Boolean {
                return oldItem.broadNo == newItem.broadNo
            }

            override fun areContentsTheSame(oldItem: Broad, newItem: Broad): Boolean {
                return oldItem == newItem
            }
        }
    }
}