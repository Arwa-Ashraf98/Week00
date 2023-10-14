package com.mad43.assignment00.presentation.model

import com.mad43.assignment00.R
import com.mad43.assignment00.domain.model.MobileDomainModel

fun MobileDomainModel.toUiModel(): MobileUiModel {
    return MobileUiModel(name = this.name, brand = mapFirstLetterToBrandName(this.brand))
}

fun mapFirstLetterToBrandName(firstLetter: String): Int? {
    return when (firstLetter) {
        BrandCategory.IPHONE.firstLetter -> R.string.iphone
        BrandCategory.SAMSUNG.firstLetter -> R.string.samsung
        else -> null
    }
}