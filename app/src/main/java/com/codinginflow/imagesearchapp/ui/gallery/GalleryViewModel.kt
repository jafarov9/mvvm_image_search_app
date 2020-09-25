package com.codinginflow.imagesearchapp.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.codinginflow.imagesearchapp.data.UnsplashRepository
import javax.inject.Inject

class GalleryViewModel @ViewModelInject constructor(private val repository: UnsplashRepository): ViewModel() {
}