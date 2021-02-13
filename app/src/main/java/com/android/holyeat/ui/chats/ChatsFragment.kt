package com.android.holyeat.ui.chats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.ChatsFragmentBinding
import com.android.holyeat.databinding.HomeFragmentBinding
import com.android.holyeat.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatsFragment : Fragment() {

    private val viewModel: ChatsViewModel by viewModels()
    private val binding: ChatsFragmentBinding by viewBinding()

    private val adapter = ChatsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.chats_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ((parentFragment as NavHostFragment).parentFragment as MainFragment).binding.bottomNavigationView.visibility =
            View.VISIBLE

        binding.rv.adapter = adapter
        viewModel.nutritionists.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        adapter.click = {
            findNavController().navigate(
                ChatsFragmentDirections.actionChatsFragmentToMessengerFragment(
                    it
                )
            )
        }
    }
}

