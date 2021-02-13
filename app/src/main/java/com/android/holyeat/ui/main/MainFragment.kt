package com.android.holyeat.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    val binding: MainFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
        setUpNavigation()
    }

    private fun setUpNavigation() {
        binding.bottomNavigationView.setupWithNavController(
            Navigation.findNavController(
                requireActivity(),
                R.id.nav_host_fragment
            )
        )

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            onNavDestinationSelected(
                item,
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
            )
            true
        }
    }
}