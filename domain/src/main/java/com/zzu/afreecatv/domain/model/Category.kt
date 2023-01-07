package com.zzu.afreecatv.domain.model

data class Category(
    val cateName: String,
    val cateNo: String,
    val cateChild: List<CategoryChild>,
)