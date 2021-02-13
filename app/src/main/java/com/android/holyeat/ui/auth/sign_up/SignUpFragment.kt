package com.android.holyeat.ui.auth.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.SignInFragmentBinding
import com.android.holyeat.databinding.SignUpFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {


    private val viewModel: SignUpViewModel by viewModels()
    private val binding: SignUpFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.status.observe(viewLifecycleOwner) {
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToCreateMainInformationFragment())
        }
        viewModel.error.observe(viewLifecycleOwner) {
           Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        binding.signInBtn.setOnClickListener {
            viewModel.signUp(binding.emailEt.text.toString(), binding.passwordEt.text.toString())
        }

    }
}