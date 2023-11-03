package com.xt.notes.domain.paging

import android.content.Context
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xt.notes.common.model.NetfItem
import com.xt.notes.common.utils.NetfChillException
import retrofit2.HttpException

private const val STARTING_PAGE_INDEX = 1

abstract class BasePagingSource<T : NetfItem>(private val context: Context) :
    PagingSource<Int, T>() {

    protected abstract suspend fun fetchItems(page: Int): List<T>

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = fetchItems(page)
            LoadResult.Page(
                data = response,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(NetfChillException(context.getString(com.xt.common.R.string.failed_loading_msg)))
        } catch (exception: HttpException) {
            LoadResult.Error(NetfChillException(context.getString(com.xt.common.R.string.failed_loading_msg)))
        }
    }
}
