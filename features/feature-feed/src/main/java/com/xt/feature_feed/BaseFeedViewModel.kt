package com.xt.feature_feed

import com.xt.notes.common.base.BaseRepository
import com.xt.notes.common.model.NetfItem
import com.xt.notes.domain.model.FeedWrapper
import com.xt.notes.domain.repository.BaseFeedRepository

open class BaseFeedViewModel<T : NetfItem>(
    private val repository: BaseFeedRepository<T>,
) : BaseFeedViewModel<List<FeedWrapper<T>>>(repository){

}
