package com.paging.example.viewmodel

import androidx.paging.PagingSource
import com.paging.example.model.Answer
import com.paging.example.repository.AnswerRepository
import javax.inject.Inject

class AnswerDataSource @Inject constructor(
    private val answerRepository: AnswerRepository
) : PagingSource<Int, Answer>() {

    companion object {
        internal const val PAGE_SIZE = 20
        private const val FIRST_PAGE = 1
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Answer> {

        try {
            val pageNumber = params.key ?: FIRST_PAGE

            val serverResponse = answerRepository.getAnswerList(
                PAGE_SIZE,
                pageNumber
            )

            val nextPageNumber = if (serverResponse.has_more) pageNumber + 1 else null
            val previousPageNumber = if (pageNumber > FIRST_PAGE) pageNumber - 1 else null

            return LoadResult.Page(
                data = serverResponse.items ?: ArrayList(),
                prevKey = previousPageNumber,
                nextKey = nextPageNumber
            )
        }
        catch (e: Exception) {
            return LoadResult.Error(e)
        }

    }

}