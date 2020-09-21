package com.codinginflow.imagesearchapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashPhoto(

    val id: String,
    val description: String?,
    val urls: UnsplashPhotoUrls,
    val user: UnsplashUser,

): Parcelable {
    @Parcelize
    data class UnsplashPhotoUrls (
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ) : Parcelable

    @Parcelize
    data class UnsplashUser(
        val name: String,
        val userName: String
    ) : Parcelable {
        val atributionUrl get() = "https://unsplash.com/$userName?utm_source=ImageSearchApp&utm_medium=referral"
    }

}