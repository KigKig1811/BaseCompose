package com.xt.paging.movie

import com.xt.notes.domain.model.Movie
import com.xt.notes.domain.repository.BasePagingRepository
import com.xt.notes.domain.utils.Trending
import com.xt.paging.base.BaseMainPagingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrendingMoviesViewModel @Inject constructor(
    @Trending repository: BasePagingRepository<Movie>
) : BaseMainPagingViewModel<Movie>(repository)

