package com.mad43.assignment00.domain.interactors

import com.mad43.assignment00.data.repo.Repo
import com.mad43.assignment00.domain.model.MobileDomainModel
import com.mad43.assignment00.domain.repo.IRepo
import kotlinx.coroutines.flow.Flow

class GetMobileTypeUseCase(private val repo : IRepo = Repo.getRepoInstance()) {

    suspend operator fun invoke() : Flow<MobileDomainModel> {
        return repo.getMobileData()
    }
}