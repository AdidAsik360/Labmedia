package com.example.labmedia.ui.result

import androidx.lifecycle.ViewModel
import com.example.labmedia.data.model.Quiz
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class QuizResult(
    val score: Int,
    val maxScore: Int,
    val passingScore: Int,
    val passed: Boolean,
    val correctCount: Int,
    val totalCount: Int,
    val startedAt: String,
    val finishedAt: String
)

class ResultViewModel : ViewModel() {

    fun calculate(quiz: Quiz, selectedAnswers: Map<String, String>): QuizResult {
        val maxScore = quiz.maxScore
        val passingScore = maxScore * quiz.passingThresholdPercent / 100

        val correctCount = quiz.questions.count { q ->
            selectedAnswers[q.id] == q.correctAnswerId
        }
        val score = quiz.questions.sumOf { q ->
            if (selectedAnswers[q.id] == q.correctAnswerId) q.weight else 0
        }

        return QuizResult(
            score = score,
            maxScore = maxScore,
            passingScore = passingScore,
            passed = score >= passingScore,
            correctCount = correctCount,
            totalCount = quiz.questions.size,
            startedAt = currentTime(),
            finishedAt = currentTime()
        )
    }

    private fun currentTime(): String {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(Date())
    }
}