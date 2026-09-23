package com.example.labmedia.data.model

data class Quiz(
    val id: String,
    val title: String,
    val description: String,
    val passingThresholdPercent: Int = 75,
    val questions: List<Question>
) {
    val maxScore: Int get() = questions.sumOf { it.weight }
}