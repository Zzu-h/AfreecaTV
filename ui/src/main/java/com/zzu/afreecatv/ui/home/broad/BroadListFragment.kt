package com.zzu.afreecatv.ui.home.broad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.zzu.afreecatv.databinding.FragmentBroadListBinding

class BroadListFragment : Fragment() {

    private var binding: FragmentBroadListBinding? = null
    private val categoryNo by lazy { requireArguments().getString(OTHER_KIND) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBroadListBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val OTHER_KIND = "otherKind"

        fun newInstance(
            categoryNo: String,
        ): BroadListFragment {
            return BroadListFragment().apply {
                arguments = bundleOf(OTHER_KIND to categoryNo)
            }
        }
    }
}