package com.zzu.afreecatv.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zzu.afreecatv.domain.model.Category
import com.zzu.afreecatv.domain.usecase.broad.GetBroadCategoryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getBroadCategoryListUseCase: GetBroadCategoryListUseCase
) : ViewModel() {

    private val _categoryList = MutableStateFlow<List<Category>>(emptyList())
    val categoryList: StateFlow<List<Category>> = _categoryList

    init {
        viewModelScope.launch {
            getBroadCategoryListUseCase()
                .onSuccess { _categoryList.emit(it) }
                .onFailure { Log.e("Tester", ": $it") }
        }
    }
}