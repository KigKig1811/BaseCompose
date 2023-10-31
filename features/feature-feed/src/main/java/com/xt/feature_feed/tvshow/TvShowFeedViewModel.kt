package com.xt.feature_feed.tvshow

import com.xt.feature_feed.base.BaseFeedViewModel
import com.xt.notes.domain.model.TvShow
import com.xt.notes.domain.repository.BaseFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowFeedViewModel @Inject constructor(repository: BaseFeedRepository<TvShow>) :
    BaseFeedViewModel<TvShow>(repository = repository)

