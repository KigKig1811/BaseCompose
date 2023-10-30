package com.xt.notes.domain.repository

import android.content.Context
import com.xt.notes.common.base.BaseRepository
import com.xt.notes.common.model.NetfItem
import com.xt.notes.domain.model.FeedWrapper
import kotlinx.coroutines.CoroutineDispatcher

class BaseFeedRepository<T: NetfItem>(
    context: Context,
    ioDispatcher: CoroutineDispatcher
) : BaseRepository<List<FeedWrapper<T>>>(context, ioDispatcher) {

    override suspend fun getSuccessResult(id: Any?): List<FeedWrapper<T>> {
        TODO("Not yet implemented")
    }

}
