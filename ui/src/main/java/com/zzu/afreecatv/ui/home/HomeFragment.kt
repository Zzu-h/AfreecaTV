package com.zzu.afreecatv.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.zzu.afreecatv.databinding.FragmentHomeBinding
import com.zzu.afreecatv.domain.model.Category
import com.zzu.afreecatv.ui.home.broad.BroadListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.lifecycleOwner = this
        initObserver()
    }

    private fun initObserver() {
        viewModel.categoryList.onEach {
            if (it.isNotEmpty()) initViewPager(it.subList(0, 5))
        }.launchIn(this.lifecycleScope)
    }

    private fun initViewPager(list: List<Category>) {
        binding?.let {
            it.vpContent.adapter = HomeVPAdapter(
                this.childFragmentManager,
                this.lifecycle,
                list.map { i -> BroadListFragment.newInstance(i.cateNo) }
            )
            TabLayoutMediator(it.tlCategory, it.vpContent) { tab, position ->
                tab.text = list[position].cateName
            }.attach()
            it.vpContent.offscreenPageLimit = list.size
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}