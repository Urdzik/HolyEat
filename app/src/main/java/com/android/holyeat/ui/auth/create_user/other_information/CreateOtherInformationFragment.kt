package com.android.holyeat.ui.auth.create_user.other_information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.R.layout.create_main_information_fragment
import com.android.holyeat.databinding.CreateMainInformationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateOtherInformationFragment : Fragment() {

     private val viewModel: CreateOtherInformationViewModel by viewModels()
    private val binding: CreateMainInformationFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.create_other_information_fragment, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}