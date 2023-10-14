package com.mad43.assignment00.domain.repo

import com.mad43.assignment00.domain.model.MobileDomainModel
import kotlinx.coroutines.flow.Flow

interface IRepo {
    suspend fun getMobileData() : Flow<MobileDomainModel>

}