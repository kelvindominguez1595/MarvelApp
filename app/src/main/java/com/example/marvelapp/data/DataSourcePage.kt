package com.example.marvelapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marvelapp.model.MarvelResults
import com.example.marvelapp.repository.CharactersRepository

class DataSourcePage (private val repo: CharactersRepository) : PagingSource<Int, MarvelResults>() {
    override fun getRefreshKey(state: PagingState<Int, MarvelResults>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition = anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarvelResults> {
      return try {
          val nextPageNumber = params.key ?: 1
          val response = repo.getCharactersPage(nextPageNumber)
          LoadResult.Page(
              data = response.data.results,
              prevKey = null,
              nextKey = if( response.data.results.isNotEmpty()) nextPageNumber + 1 else null
          )
      } catch (e: Exception){
          LoadResult.Error(e)
      }
    }
}