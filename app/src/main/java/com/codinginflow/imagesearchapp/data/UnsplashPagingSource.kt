package com.codinginflow.imagesearchapp.data

import android.util.Log
import androidx.paging.PagingSource
import com.codinginflow.imagesearchapp.api.UnsplashApi
import com.codinginflow.imagesearchapp.model.UnsplashPhoto
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class UnsplashPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try {
            val response = unsplashApi.searchPhotos(query, position, params.loadSize)

            Log.e("ccxcxc", "Size: $response")

            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if(position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if(photos.isEmpty()) null else position + 1
            )

        } catch (exception: IOException) {
            Log.e("ccxcxc", "Error: " + exception.localizedMessage)
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            Log.e("ccxcxc", "HttpError: " + exception.localizedMessage)
            LoadResult.Error(exception)
        }


    }

}