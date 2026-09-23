package com.example.labmedia.data

import com.example.labmedia.data.model.Quiz
import com.example.labmedia.data.remote.QuizApi

class QuizRepository(
    private val api: QuizApi = QuizApi()
) {
    suspend fun getQuiz(): Result<Quiz> = runCatching { api.fetchQuiz() }
}