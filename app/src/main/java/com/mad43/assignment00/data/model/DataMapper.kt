package com.mad43.assignment00.data.model

import com.mad43.assignment00.domain.model.MobileDomainModel

fun MobileResponseDataModel.toDomainModel(): MobileDomainModel {
    return MobileDomainModel(name = this.name ?: "", brand = this.brand ?: "")
}