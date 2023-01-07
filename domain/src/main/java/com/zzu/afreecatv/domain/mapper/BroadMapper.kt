package com.zzu.afreecatv.domain.mapper

import com.zzu.afreecatv.data.dto.BroadDto
import com.zzu.afreecatv.domain.model.Broad

fun BroadDto.toModel(): Broad {
    return Broad(
        broadNo,
        broadThumb,
        broadTitle,
        broadGrade,
        profileImg,
        totalViewCnt,
        userId,
        userNick,
    )
}