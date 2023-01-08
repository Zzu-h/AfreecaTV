package com.zzu.afreecatv.ui.home.broad.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.zzu.afreecatv.databinding.ItemBroadBinding
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.ui.home.broad.viewholder.BroadViewHolder

class BroadRVAdapter :
    PagingDataAdapter<Broad, BroadViewHolder>(diffUtil) {

    lateinit var listener: OnClickListener

    override fun onBindViewHolder(holder: BroadViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, listener) }
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

    interface OnClickListener {
        fun onClickItem(item: Broad)
    }
}