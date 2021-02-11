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


    class ChatsViewHolder(private val binding: ChatItemBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(data: NutritionistModel, position: Int){
                binding.messageTv.text = data.rank
                binding.nameTv.text = data.name

                Glide.with(binding.root)
                    .load(data.image)
                    .circleCrop()
                    .into(binding.photoIv)
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