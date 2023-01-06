package com.zzu.afreecatv.data.dto


import com.google.gson.annotations.SerializedName

data class BroadListDto(
    @SerializedName("broad")
    val broad: List<BroadDto>,
    @SerializedName("page_no")
    val pageNo: Int,
    @SerializedName("time")
    val time: Int,
    @SerializedName("total_cnt")
    val totalCnt: Int
)