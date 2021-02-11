package com.android.holyeat.ui.auth.create_user.other_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.CreateOtherInformationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateOtherInformationFragment : Fragment() {

    private val viewModel: CreateOtherInformationViewModel by viewModels()
    private val binding: CreateOtherInformationFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.create_other_information_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = CreateOtherInformationFragmentArgs.fromBundle(requireArguments())
        val data = args.data

        binding.signInBtn.setOnClickListener {
           viewModel.setUser( data.apply { weight = binding.weightTv.text.toString().toInt()
               growth=  binding.heightTv.text.toString().toInt()})
        }

        binding.text2.setOnClickListener {
            viewModel.setUser(data)
        }

        viewModel.status.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_global_mainFragment)
        }
    }


}