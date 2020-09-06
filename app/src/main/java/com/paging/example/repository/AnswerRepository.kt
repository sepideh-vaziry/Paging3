package com.paging.example.repository

import com.paging.example.model.Answer
import com.paging.example.model.ServerResponse

abstract class AnswerRepository {

    abstract suspend fun getAnswerList(pageSize: Int, page: Int) : ServerResponse<Answer>

}