package com.xt.paging.base

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.xt.notes.common.model.NetfItem
import com.xt.notes.domain.repository.BasePagingRepository
import kotlinx.coroutines.flow.Flow

open class BaseMainPagingViewModel<T : NetfItem>(
    repository: BasePagingRepository<T>
) : BasePagingViewModel<T>() {

    override val pagingDataFlow: Flow<PagingData<T>> =
        repository.fetchResultStream().cachedIn(viewModelScope)
}
