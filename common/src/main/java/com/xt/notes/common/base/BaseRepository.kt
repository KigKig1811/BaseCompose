package com.xt.notes.common.base

import android.content.Context
import com.xt.common.R
import com.xt.notes.common.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository<T>(
    private val context: Context,
    private val ioDispatcher: CoroutineDispatcher
) {
    protected abstract suspend fun getSuccessResult(id: Any?): T

    fun getResult(id: Any?): Flow<Resource<T>> = flow {
        emit(Resource.Loading)
        try {
            emit(Resource.Success(getSuccessResult(id)))
        } catch (t: Throwable) {
            emit(Resource.Error(context.getString(R.string.failed_loading_msg)))
        }
    }
}