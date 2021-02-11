package com.android.holyeat.ui.messager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.MessengerFragmentBinding

class MessengerFragment : Fragment() {

    private val viewModel: MessengerViewModel by viewModels()
    private val binding: MessengerFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.messenger_fragment, container, false)
    }

}

