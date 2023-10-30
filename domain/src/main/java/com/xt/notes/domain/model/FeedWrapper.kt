package com.xt.notes.domain.model

import androidx.annotation.StringRes
import com.xt.notes.common.model.NetfItem

class FeedWrapper<T: NetfItem>(
    val feeds: List<T>,
    @StringRes val sortTypeResourceId: Int,
    val sortType: SortType
)

