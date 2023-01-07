package com.zzu.afreecatv.domain.model

import java.io.Serializable

data class Broad(
    val broadNo: String,
    val broadThumb: String,
    val broadTitle: String,
    val broadGrade: String,
    val profileImg: String,
    val totalViewCnt: String,
    val userId: String,
    val userNick: String,
) : Serializable