package com.zzu.afreecatv.domain.mapper

import com.zzu.afreecatv.data.dto.BroadCategoryDto
import com.zzu.afreecatv.data.dto.ChildDto
import com.zzu.afreecatv.domain.model.Category
import com.zzu.afreecatv.domain.model.CategoryChild

fun BroadCategoryDto.toModel(): Category {
    return Category(
        cateName = cateName,
        cateNo = cateNo,
        cateChild = child.map { it.toModel() }
    )
}

private fun ChildDto.toModel(): CategoryChild {
    return CategoryChild(
        cateName = cateName,
        cateNo = cateNo,
    )
}