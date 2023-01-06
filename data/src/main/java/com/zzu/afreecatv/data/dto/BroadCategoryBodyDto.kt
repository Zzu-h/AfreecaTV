package com.zzu.afreecatv.data.dto

import com.google.gson.annotations.SerializedName

data class BroadCategoryBodyDto(
    @SerializedName("broad_category")
    val broadCategory: List<BroadCategoryDto>
)