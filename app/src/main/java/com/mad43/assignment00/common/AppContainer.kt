package com.mad43.assignment00.common

import com.mad43.assignment00.data.datasource.LocalDataSource
import com.mad43.assignment00.data.repo.Repo
import com.mad43.assignment00.domain.interactors.GetMobileTypeUseCase
import com.mad43.assignment00.presentation.viewmodel.MobileViewModelFactory
import kotlinx.coroutines.Dispatchers

class AppContainer {

    private val localDataSource = LocalDataSource()
    private val defaultDispatcher = Dispatchers.Default
    private val repo = Repo(localDataSource = localDataSource , dispatcher = defaultDispatcher)
    private val getMobileTypeUseCase = GetMobileTypeUseCase(repo = repo)

    val mainViewModelFactory = MobileViewModelFactory(getMobileTypeUseCase)


}