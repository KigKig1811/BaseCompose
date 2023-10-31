package com.xt.feature_feed.movie

import com.xt.feature_feed.base.BaseFeedViewModel
import com.xt.notes.domain.model.Movie
import com.xt.notes.domain.repository.BaseFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieFeedViewModel @Inject constructor(repository: BaseFeedRepository<Movie>) :
    BaseFeedViewModel<Movie>(repository = repository)
