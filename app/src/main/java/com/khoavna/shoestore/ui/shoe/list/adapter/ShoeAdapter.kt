package com.khoavna.shoestore.ui.shoe.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.khoavna.shoestore.data.model.Shoe
import com.khoavna.shoestore.databinding.ItemShoeBinding

class ShoeAdapter(
    private val shoeListener: ShoeListener
) : ListAdapter<Shoe, ShoeAdapter.ShoeViewHolder>(DiffUtilCallBack()) {
    inner class ShoeViewHolder(private val binding: ItemShoeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(shoe: Shoe) {
            binding.also {
                it.shoe = shoe
                it.shoeListener = shoeListener
                it.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        return ShoeViewHolder(
            ItemShoeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.onBind(shoe)
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Shoe>() {
        override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean =
            oldItem.id == newItem.id
    }
}

fun interface ShoeListener {
    fun onItemClick(shoe: Shoe)
}