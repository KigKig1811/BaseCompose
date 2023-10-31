package com.xt.notes.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetfWrapper<T : NetworkNetfItem>(
    @Json(name = "results")
    val items: List<T>
)
