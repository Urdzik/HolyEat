package com.android.holyeat.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.ProfileFragmentBinding
import com.android.holyeat.ui.main.MainFragment
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()
    private val binding: ProfileFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupUserInfo()
    }

    private fun setupUserInfo() {
        viewModel.user.observe(viewLifecycleOwner) {
            binding.ageInfo.text = it.age
            binding.cityInfo.text = it.city
            binding.weightInfo.text = it.weight.toString()
            binding.heightInfo.text = it.growth.toString()
            binding.nameTv.text = it.name

            Glide.with(binding.root)
                .load("https://image.prntscr.com/image/RA3G17w5RlGY1Kg3avjMZg.jpg")
                .circleCrop()
                .into(binding.userIcon)
        }


    }

    private fun setupView() {
        ((parentFragment as NavHostFragment).parentFragment as MainFragment).binding.bottomNavigationView.visibility =
            View.VISIBLE
        binding.callBtn.setOnClickListener {
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToPlansFragment())
        }
    }
}

