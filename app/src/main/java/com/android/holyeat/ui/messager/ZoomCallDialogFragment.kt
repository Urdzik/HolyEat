package com.android.holyeat.ui.messager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.android.holyeat.R

class ZoomCallDialogFragment : DialogFragment() {
    companion object {
        fun newInstance(): ZoomCallDialogFragment {
            return ZoomCallDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.zoom_fragment, container, false)
    }
}