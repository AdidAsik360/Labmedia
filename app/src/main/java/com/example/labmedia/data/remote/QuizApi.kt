package com.example.labmedia.data.remote

import com.example.labmedia.data.model.Answer
import com.example.labmedia.data.model.Question
import com.example.labmedia.data.model.Quiz
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class QuizApi {

    suspend fun fetchQuiz(): Quiz {
        delay(1500.milliseconds)
        return mockQuiz()
    }

    private fun mockQuiz() = Quiz(
        id = "quiz_1",
        title = "Аттестация по информационной безопасности для сотрудников офиса",
        description = "В итоговый результат попадёт последняя завершённая попытка",
        questions = listOf(
            Question(
                id = "q14",
                number = 14,
                text = "Название вопроса из категории, длинный вопрос в 2 строки для проверки межстрочного расстояния",
                weight = 20,
                correctAnswerId = "a2",
                answers = listOf(
                    Answer("a1", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a2", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a3", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a4", "Вариант ответа 2, длинный, показывает поведение блока")
                )
            ),
            Question(
                id = "q15",
                number = 15,
                text = "Название вопроса из категории, длинный вопрос в 2 строки для проверки межстрочного расстояния",
                weight = 20,
                correctAnswerId = "a2",
                answers = listOf(
                    Answer("a1", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a2", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a3", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a4", "Вариант ответа 2, длинный, показывает поведение блока")
                )
            ),
            Question(
                id = "q16",
                number = 16,
                text = "Название вопроса из категории, длинный вопрос в 2 строки для проверки межстрочного расстояния",
                weight = 20,
                correctAnswerId = "a2",
                answers = listOf(
                    Answer("a1", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a2", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a3", "Вариант ответа 2, длинный, показывает поведение блока"),
                    Answer("a4", "Вариант ответа 2, длинный, показывает поведение блока")
                )
            )
        )
    )
}