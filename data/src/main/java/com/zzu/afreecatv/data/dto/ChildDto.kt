package com.zzu.afreecatv.data.dto

import com.google.gson.annotations.SerializedName

data class ChildDto(
    @SerializedName("cate_name")
    val cateName: String,
    @SerializedName("cate_no")
    val cateNo: String
)