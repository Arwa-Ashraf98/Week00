package com.mad43.assignment00.data.repo

import com.mad43.assignment00.data.datasource.ILocalDataSource
import com.mad43.assignment00.data.datasource.LocalDataSource
import com.mad43.assignment00.data.model.toDomainModel
import com.mad43.assignment00.domain.model.MobileDomainModel
import com.mad43.assignment00.domain.repo.IRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repo(
    private val localDataSource: ILocalDataSource = LocalDataSource.getLocalDataSource(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) : IRepo {
    companion object {
        @Volatile
        private var repo: IRepo? = null

        fun getRepoInstance() = run {
            repo ?: synchronized(this) {
                val temp = Repo()
                repo = temp
                temp
            }
        }
    }

    private var mobilesDomainModel = mutableListOf<MobileDomainModel>()

    override suspend fun getMobileData(): Flow<MobileDomainModel> {
        val mobilesDataModel = localDataSource.getData()
        for (mobileDataModel in mobilesDataModel) {
            mobilesDomainModel.add(mobileDataModel.toDomainModel())
        }
        return flow {
            for (mobileDomainModel in mobilesDomainModel) {
                emit(mobileDomainModel)
                delay(1000)
            }
        }.catch {
            // handle emitting error
        }.flowOn(dispatcher)
    }

}