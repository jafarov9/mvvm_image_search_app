package com.codinginflow.imagesearchapp.api

import com.codinginflow.imagesearchapp.model.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)