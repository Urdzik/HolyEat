package com.android.holyeat.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.MessengerFragmentBinding
import com.android.holyeat.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()
    private val binding: ProfileFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

}

