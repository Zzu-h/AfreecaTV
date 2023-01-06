package com.zzu.afreecatv.data.dto


import com.google.gson.annotations.SerializedName

data class BroadCategoryDto(
    @SerializedName("cate_name")
    val cateName: String,
    @SerializedName("cate_no")
    val cateNo: String,
    @SerializedName("child")
    val child: List<ChildDto>
)