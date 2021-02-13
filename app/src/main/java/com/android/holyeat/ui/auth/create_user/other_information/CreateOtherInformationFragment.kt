package com.android.holyeat.ui.auth.create_user.other_information

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

        binding.backBtn.setOnClickListener { _-> findNavController().popBackStack() }
        binding.heightSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
               binding.heightTv.text = i.toString();
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.weightSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                binding.weightTv.text = i.toString();
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        binding.signInBtn.setOnClickListener {
            viewModel.setUser(data.apply {
                weight = binding.weightTv.text?.toString()?.toInt() ?: 0
                growth = binding.heightTv.text?.toString()?.toInt() ?: 0
            })
        }

        binding.skip.setOnClickListener {
            viewModel.setUser(data)
        }



        viewModel.status.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_global_mainFragment)
        }
    }
}