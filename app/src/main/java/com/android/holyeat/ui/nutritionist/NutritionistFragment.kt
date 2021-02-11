package com.android.holyeat.ui.nutritionist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.NutritionistFragmentBinding
import com.android.holyeat.ui.home.HomeAdapter
import com.android.holyeat.ui.nutritionist.NutritionistFragmentArgs.Companion.fromBundle

class NutritionistFragment : Fragment() {

    private val viewModel: NutritionistViewModel by viewModels()
    private val binding: NutritionistFragmentBinding by viewBinding()

    private var adapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.nutritionist_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = NutritionistFragmentArgs.fromBundle(requireArguments())
        val data = args.data


    }
}