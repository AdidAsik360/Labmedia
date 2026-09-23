package com.example.labmedia.ui.result

import androidx.lifecycle.ViewModel
import com.example.labmedia.data.model.Quiz

data class QuizResult(
    val score: Int,
    val maxScore: Int,
    val passingScore: Int,
    val passed: Boolean,
    val startedAt: String,
    val finishedAt: String
)

class ResultViewModel : ViewModel() {

    fun calculate(quiz: Quiz, selectedAnswers: Map<String, String>): QuizResult {
        val maxScore = quiz.maxScore
        val passingScore = maxScore * quiz.passingThresholdPercent / 100

        val score = quiz.questions.sumOf { question ->
            if (selectedAnswers[question.id] == question.correctAnswerId) {
                question.weight
            } else {
                0
            }
        }

        return QuizResult(
            score = score,
            maxScore = maxScore,
            passingScore = passingScore,
            passed = score >= passingScore,
            startedAt = currentTime(),
            finishedAt = currentTime()
        )
    }

    private fun currentTime(): String {
        val sdf = java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault())
        return sdf.format(java.util.Date())
    }
}