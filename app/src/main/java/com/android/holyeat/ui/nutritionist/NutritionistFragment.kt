package com.android.holyeat.ui.nutritionist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.NutritionistFragmentBinding
import com.android.holyeat.ui.home.HomeAdapter
import com.android.holyeat.ui.main.MainFragment
import com.bumptech.glide.Glide

class NutritionistFragment : Fragment() {

    private val binding: NutritionistFragmentBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ((parentFragment as NavHostFragment).parentFragment as MainFragment).binding.bottomNavigationView.visibility =
            View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.nutritionist_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = NutritionistFragmentArgs.fromBundle(requireArguments())
        val data = args.data
        binding.costNumberTv.text = "${data.cost} грн"
        binding.expNumberTv.text = "${data.year} років"
        binding.nameTv.text = data.name
        binding.ratingBar.rating = data.rating
        binding.messageTv.text = data.rank
        Glide.with(binding.root)
            .load(data.image)
            .circleCrop()
            .into(binding.userIcon)

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.goToMessage.setOnClickListener {
            findNavController().navigate(
                NutritionistFragmentDirections.actionNutritionistFragmentToMessengerFragment(
                    data
                )
            )
        }

    }
}