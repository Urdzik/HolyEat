package com.android.holyeat.ui.plans

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.android.holyeat.R
import com.android.holyeat.databinding.PlansFragmentBinding

class PlansFragment : Fragment() {

    private val binding: PlansFragmentBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.plans_fragment, container, false)
    }

}

