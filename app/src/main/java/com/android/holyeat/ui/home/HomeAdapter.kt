package com.android.holyeat.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.holyeat.R
import com.android.holyeat.data.model.NutritionistModel
import com.android.holyeat.databinding.NutritionistItemBinding
import com.bumptech.glide.Glide

class HomeAdapter : ListAdapter<NutritionistModel, HomeAdapter.HomeViewHolder>(
    HomeDiffUtils()
) {

    var click: (data:NutritionistModel)-> Unit ={}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            NutritionistItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.nutritionist_item, parent, false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


   inner class HomeViewHolder(private val binding: NutritionistItemBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(data: NutritionistModel){
                binding.messageTv.text = data.rank
                binding.nameTv.text = data.name
                binding.costNumberTv.text = "${data.cost} грн"
                binding.expNumberTv.text = "${data.year} років"
                binding.ratingBar.rating = data.rating
                Glide.with(binding.root)
                    .load(data.image)
                    .circleCrop()
                    .into(binding.photoIv)

                binding.root.setOnClickListener {
                    click(data)
                }
            }
        }

    class HomeDiffUtils : DiffUtil.ItemCallback<NutritionistModel>() {
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