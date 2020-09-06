package com.paging.example.repository

import com.paging.example.model.Answer
import com.paging.example.model.ServerResponse
import com.paging.example.network.ApiService
import javax.inject.Inject

class AnswerRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AnswerRepository() {

    companion object {
        private const val SITE_NAME = "stackoverflow"
    }

    //**********************************************************************************************
    override suspend fun getAnswerList(pageSize: Int, page: Int): ServerResponse<Answer> {
        return apiService.getAnswerList(SITE_NAME, pageSize, page)
    }

}