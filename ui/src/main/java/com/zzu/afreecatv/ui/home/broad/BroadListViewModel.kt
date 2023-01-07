package com.zzu.afreecatv.ui.home.broad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.usecase.broad.GetBroadListByCategoryNoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BroadListViewModel @Inject constructor(
    private val getBroadListByCategoryNoUseCase: GetBroadListByCategoryNoUseCase
) : ViewModel() {

    private val _broadList = MutableStateFlow<List<Broad>>(emptyList())
    val broadList: StateFlow<List<Broad>> = _broadList

    lateinit var categoryNo: String

    private var pageNo = 1

    fun fetchBroadList(pageNo: Int = this.pageNo) {
        viewModelScope.launch {
            getBroadListByCategoryNoUseCase(categoryNo, pageNo)
                .onSuccess {
                    val prev = broadList.value
                    _broadList.emit(prev + it)
                }
        }
    }
}