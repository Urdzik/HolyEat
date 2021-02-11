package com.android.holyeat.ui.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.ChatsFragmentBinding
import com.android.holyeat.databinding.HomeFragmentBinding

class ChatsFragment : Fragment() {

    private val viewModel: ChatsViewModel by viewModels()
    private val binding: ChatsFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.chats_fragment, container, false)
    }

}

