package com.zzu.afreecatv.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zzu.afreecatv.data.datasource.broad.BroadDataSource
import com.zzu.afreecatv.data.dto.BroadDto
import kotlinx.coroutines.delay

class BroadPagingSource(
    private val broadDataSource: BroadDataSource,
    private val query: String,
) : PagingSource<Int, BroadDto>() {

    override fun getRefreshKey(state: PagingState<Int, BroadDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BroadDto> {
        return try {
            val page = params.key ?: 1

            val item = broadDataSource.getBroadListByCategoryNo(query, page)

            if (page != 1) delay(500L)

            LoadResult.Page(
                data = item,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (item.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }
}