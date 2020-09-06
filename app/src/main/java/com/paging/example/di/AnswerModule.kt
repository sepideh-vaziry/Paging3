package com.paging.example.di

import com.paging.example.repository.AnswerRepository
import com.paging.example.repository.AnswerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AnswerModule {

    @Binds
    abstract fun provideChallengeRepository(
        answerRepositoryImpl: AnswerRepositoryImpl
    ) : AnswerRepository

}