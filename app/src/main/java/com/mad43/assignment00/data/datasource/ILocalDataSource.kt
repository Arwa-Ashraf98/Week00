package com.mad43.assignment00.data.datasource

import com.mad43.assignment00.data.model.MobileResponseDataModel

interface ILocalDataSource {
    suspend fun getData() : List<MobileResponseDataModel>
}