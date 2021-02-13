package com.android.holyeat.ui.auth.create_user.main_information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.data.model.UserModel
import com.android.holyeat.databinding.CreateMainInformationFragmentBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateMainInformationFragment : Fragment() {

    private val binding: CreateMainInformationFragmentBinding by viewBinding()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.create_main_information_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.root)
            .load("https://image.prntscr.com/image/RA3G17w5RlGY1Kg3avjMZg.jpg")
            .circleCrop()
            .into(binding.userIcon)

        binding.signInBtn.setOnClickListener {
            findNavController().navigate(
                CreateMainInformationFragmentDirections.actionCreateMainInformationFragmentToCreateOtherInformationFragment(
                    UserModel(
                        age = binding.setAgeEt.text.toString() ?: "не вказано",
                        name = binding.setNameEt.text.toString() ?: "не вказано",
                        sex = "не вказано",
                        city = binding.setCityEt.text.toString() ?: "не вказано",
                        growth = 0,
                        weight = 0,
                        photo = "https://image.prntscr.com/image/RA3G17w5RlGY1Kg3avjMZg.jpg"
                    )
                )
            )
        }
        binding.skip.setOnClickListener {
            findNavController().navigate(
                CreateMainInformationFragmentDirections.actionCreateMainInformationFragmentToCreateOtherInformationFragment(
                    UserModel(
                        age = "не вказано",
                        name = "не вказано",
                        sex = "не вказано",
                        city = "не вказано",
                        growth = 0,
                        weight = 0,
                        photo = ""
                    )
                )
            )
        }
    }


}