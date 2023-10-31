package com.xt.feature_feed

import com.xt.notes.common.base.BaseRefreshViewModel
import com.xt.notes.common.model.NetfItem
import com.xt.notes.domain.model.FeedWrapper
import com.xt.notes.domain.repository.BaseFeedRepository

open class BaseFeedViewModel<T : NetfItem>(
    private val repository: BaseFeedRepository<T>,
) : BaseRefreshViewModel<List<FeedWrapper<T>>>(repository)
