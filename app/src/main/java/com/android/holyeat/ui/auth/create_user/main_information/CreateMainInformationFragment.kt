package com.android.holyeat.ui.auth.create_user.main_information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.data.model.UserModel
import com.android.holyeat.databinding.CreateMainInformationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class CreateMainInformationFragment : Fragment() {

    private val binding: CreateMainInformationFragmentBinding by viewBinding()

    private var file: File? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.create_main_information_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInBtn.setOnClickListener {
            findNavController().navigate(CreateMainInformationFragmentDirections.actionCreateMainInformationFragmentToCreateOtherInformationFragment(
                UserModel(year = binding.setAgeEt.text.toString().toInt(), name = binding.setNameEt.text.toString(), sex = "", city = binding.setCityEt.text.toString(), growth = 0, weight = 0)
            ))
        }
        binding.text2.setOnClickListener {
            findNavController().navigate(CreateMainInformationFragmentDirections.actionCreateMainInformationFragmentToCreateOtherInformationFragment(
                UserModel(year = 0, name = "", sex = "", city = "", growth = 0, weight = 0)
            ))
        }
    }


}