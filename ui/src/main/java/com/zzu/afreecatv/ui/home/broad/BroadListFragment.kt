package com.zzu.afreecatv.ui.home.broad

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.zzu.afreecatv.R
import com.zzu.afreecatv.databinding.FragmentBroadListBinding
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.ui.home.broad.adapter.BroadRVAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class BroadListFragment : Fragment() {

    private var binding: FragmentBroadListBinding? = null
    private val viewModel by viewModels<BroadListViewModel>()
    private val categoryNo by lazy { requireArguments().getString(CATEGORY_NO) as String }

    private lateinit var broadRVAdapter: BroadRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBroadListBinding.inflate(inflater)
        viewModel.categoryNo = categoryNo

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.lifecycleOwner = this

        initRecyclerView()
        initObserver()

        viewModel.fetchBroadList()
    }

    private fun initObserver() {
        viewModel.broadList.onEach {
            broadRVAdapter.submitList(it)
        }.launchIn(this.lifecycleScope)
    }

    private fun initRecyclerView() {
        broadRVAdapter = BroadRVAdapter().apply {
            listener = object : BroadRVAdapter.OnClickListener {
                override fun onClickItem(item: Broad) {
                    val bundle = Bundle()
                    bundle.putSerializable("broad", item)
                    findNavController().navigate(R.id.action_HomeFragment_to_DetailFragment, bundle)
                    Log.d("Tester", "onClickItem: $item")
                }
            }
        }
        binding?.rvBroadList?.adapter = broadRVAdapter
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val CATEGORY_NO = "categoryNo"

        fun newInstance(
            categoryNo: String,
        ): BroadListFragment {
            return BroadListFragment().apply {
                arguments = bundleOf(CATEGORY_NO to categoryNo)
            }
        }
    }
}