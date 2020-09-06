package com.paging.example.network

import com.paging.example.model.Answer
import com.paging.example.model.ServerResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("answers")
    suspend fun getAnswerList(
        @Query("site") siteName: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ) : ServerResponse<Answer>

}