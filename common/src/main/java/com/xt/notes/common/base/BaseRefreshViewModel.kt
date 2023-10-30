package com.xt.notes.common.base

open class BaseRefreshViewModel<T>(
    private val repository: BaseRepository<T>,
    private val id: Any? = null
) : BaseViewModel<T>(repository, id) {
    init {
        refresh()
    }
}
