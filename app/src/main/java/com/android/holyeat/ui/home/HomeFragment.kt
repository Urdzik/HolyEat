package com.android.holyeat.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.HomeFragmentBinding
import com.android.holyeat.databinding.SignInFragmentBinding

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container,false)
    }


}