package com.zzu.afreecatv.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.zzu.afreecatv.databinding.FragmentDetailBinding
import com.zzu.afreecatv.domain.model.Broad

class DetailFragment : Fragment() {

    private var binding: FragmentDetailBinding? = null
    private val broad: Broad by lazy { arguments?.getSerializable("broad") as Broad }

    private lateinit var callback: OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.lifecycleOwner = this
        binding?.item = broad
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}