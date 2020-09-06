package com.paging.example.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.paging.example.model.Answer
import kotlinx.coroutines.flow.Flow

class AnswerListViewModel @ViewModelInject constructor(
    application: Application,
    private val answerDataSource: AnswerDataSource
) : AndroidViewModel(application) {

    //**********************************************************************************************
    fun getAnswerList() : Flow<PagingData<Answer>> {

        return Pager(
            PagingConfig(AnswerDataSource.PAGE_SIZE)
        ) {
            answerDataSource
        }
            .flow
            .cachedIn(viewModelScope)

    }

}