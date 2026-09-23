package com.example.labmedia.data.remote

import com.example.labmedia.data.model.Answer
import com.example.labmedia.data.model.Question
import com.example.labmedia.data.model.Quiz
import kotlinx.coroutines.delay
import java.io.IOException

class QuizApi {

    suspend fun fetchQuiz(): Quiz {
        delay(1500)
        if (Math.random() < 0.2) {
            throw IOException("Не удалось загрузить тест. Проверьте соединение.")
        }
        return mockQuiz()
    }

    private fun mockQuiz() = Quiz(
        id = "quiz_1",
        title = "Аттестация по информационной безопасности для сотрудников офиса",
        description = "В итоговый результат попадет последняя завершенная попытка",
        questions = listOf(
            Question(
                id = "q1",
                text = "Что такое фишинг и как его распознать в письме от неизвестного отправителя?",
                weight = 20,
                correctAnswerId = "a2",
                answers = listOf(
                    Answer("a1", "Способ шифрования данных"),
                    Answer("a2", "Попытка выманить конфиденциальные данные через поддельные сообщения"),
                    Answer("a3", "Метод резервного копирования"),
                    Answer("a4", "Протокол передачи файлов")
                )
            ),
            Question(
                id = "q2",
                text = "Какой пароль считается наиболее надежным для корпоративной учетной записи?",
                weight = 20,
                correctAnswerId = "a3",
                answers = listOf(
                    Answer("a1", "Дата рождения"),
                    Answer("a2", "Имя и фамилия"),
                    Answer("a3", "Длинная фраза с цифрами и символами"),
                    Answer("a4", "Последовательность 12345678")
                )
            ),
            Question(
                id = "q3",
                text = "Можно ли передавать служебную информацию через личные мессенджеры?",
                weight = 20,
                correctAnswerId = "a2",
                answers = listOf(
                    Answer("a1", "Да, если информация не секретная"),
                    Answer("a2", "Нет, только через корпоративные каналы связи"),
                    Answer("a3", "Да, если удалить сообщение после прочтения"),
                    Answer("a4", "Только в нерабочее время")
                )
            ),
            Question(
                id = "q4",
                text = "Что нужно сделать при обнаружении подозрительного вложения в письме?",
                weight = 20,
                correctAnswerId = "a1",
                answers = listOf(
                    Answer("a1", "Не открывать"),
                    Answer("a2", "Открыть и проверить антивирусом"),
                    Answer("a3", "Переслать коллегам для проверки"),
                    Answer("a4", "Удалить письмо и забыть")
                )
            ),
            Question(
                id = "q5",
                text = "Как часто рекомендуется менять корпоративный пароль?",
                weight = 20,
                correctAnswerId = "a3",
                answers = listOf(
                    Answer("a1", "Раз в год"),
                    Answer("a2", "Никогда, если он сложный"),
                    Answer("a3", "В соответствии с политикой компании"),
                    Answer("a4", "Раз в 5 лет")
                )
            )
        )
    )
}