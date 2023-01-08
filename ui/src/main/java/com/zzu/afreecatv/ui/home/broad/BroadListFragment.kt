package com.zzu.afreecatv.ui.home.broad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.zzu.afreecatv.R
import com.zzu.afreecatv.databinding.FragmentBroadListBinding
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.ui.detail.DetailFragment
import com.zzu.afreecatv.ui.home.broad.adapter.BroadRVAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

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
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.broadList.collectLatest { broadRVAdapter.submitData(it) }
        }
        broadRVAdapter.loadStateFlow.onEach {
            binding?.piPrepend?.isVisible = it.source.prepend is LoadState.Loading
            binding?.piAppend?.isVisible = it.source.append is LoadState.Loading
        }.launchIn(this.lifecycleScope)
    }

    private fun initRecyclerView() {
        broadRVAdapter = BroadRVAdapter().apply {
            listener = object : BroadRVAdapter.OnClickListener {
                override fun onClickItem(item: Broad) {
                    val bundle = Bundle().apply { putSerializable("broad", item) }

                    requireParentFragment().parentFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.fcv_content, DetailFragment().apply { arguments = bundle })
                        .commitAllowingStateLoss()
                }
            }
        }
        binding?.rvBroadList?.adapter = broadRVAdapter
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