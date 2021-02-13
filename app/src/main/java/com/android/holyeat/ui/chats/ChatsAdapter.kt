package com.android.holyeat.ui.chats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.holyeat.R
import com.android.holyeat.data.model.NutritionistModel
import com.android.holyeat.databinding.ChatItemBinding
import com.bumptech.glide.Glide

class ChatsAdapter : ListAdapter<NutritionistModel, ChatsAdapter.ChatsViewHolder>(
    ChatsDiffUtils()
) {

    var click: (data: NutritionistModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        return ChatsViewHolder(
            ChatItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.chat_item, parent, false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }


    inner class ChatsViewHolder(private val binding: ChatItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val list = listOf<String>(
            "Ви найняли лікара-дієто...  ",
            "Так, звісно!",
            "Так, звісно!",
            "Так, звісно!",
            "Так, звісно!",
            "Так, звісно!"
        )

        fun bind(data: NutritionistModel, position: Int) {
            binding.messageTv.text = list[position]
            binding.nameTv.text = data.name

            Glide.with(binding.root)
                .load(data.image)
                .circleCrop()
                .into(binding.photoIv)

            binding.root.setOnClickListener {
                click(data)
            }
        }
    }

    class ChatsDiffUtils : DiffUtil.ItemCallback<NutritionistModel>() {
        override fun areItemsTheSame(
            oldItem: NutritionistModel,
            newItem: NutritionistModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: NutritionistModel,
            newItem: NutritionistModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }


}