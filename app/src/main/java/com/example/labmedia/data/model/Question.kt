package com.example.labmedia.data.model

data class Question(
    val id: String,
    val number: Int,
    val text: String,
    val weight: Int,
    val answers: List<Answer>,
    val correctAnswerId: String
)