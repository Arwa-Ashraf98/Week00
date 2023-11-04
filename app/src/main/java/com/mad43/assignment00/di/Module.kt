package com.mad43.assignment00.di

import com.mad43.assignment00.data.datasource.LocalDataSource
import com.mad43.assignment00.data.repo.Repo
import com.mad43.assignment00.domain.interactors.GetMobileTypeUseCase
import com.mad43.assignment00.domain.repo.IRepo
import com.mad43.assignment00.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        LocalDataSource()
    }

    factory { Dispatchers.Default }

    single<IRepo> { Repo(localDataSource = get(), dispatcher = get()) }

    factory { GetMobileTypeUseCase(repo = get()) }
}

val viewModelModule = module {

    viewModel {
        MainViewModel(useCase = get() as GetMobileTypeUseCase)
    }
}