package com.zzu.afreecatv.ui.home.broad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.usecase.broad.GetBroadListByCategoryNoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BroadListViewModel @Inject constructor(
    private val getBroadListByCategoryNoUseCase: GetBroadListByCategoryNoUseCase
) : ViewModel() {

    private val _broadList = MutableStateFlow<PagingData<Broad>>(PagingData.empty())
    val broadList: StateFlow<PagingData<Broad>> = _broadList

    lateinit var categoryNo: String

    fun fetchBroadList(size: Int = 60) {
        viewModelScope.launch(Dispatchers.IO) {
            getBroadListByCategoryNoUseCase(categoryNo, size)
                .cachedIn(viewModelScope)
                .collect { _broadList.emit(it) }
        }
    }
}