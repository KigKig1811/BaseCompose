package com.xt.paging.base

import androidx.lifecycle.ViewModel
import com.xt.notes.common.model.NetfItem
import kotlinx.coroutines.flow.Flow

abstract class BasePagingViewModel<T: NetfItem> : ViewModel() {
    //abstract val pagingDataFlow: Flow<PagingData<T>>
}
