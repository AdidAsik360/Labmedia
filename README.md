# labmedia_test_android
Тестовое приложение:
# Экраны #
1. Карточка теста
2. Прохождение
3. Результат

# Запуск #

1. Открыть проект в Android Studio
2. **Sync Now** - Gradle
3. Запуск на эмуляторе или устройстве (API 25+): Run

# Тест #
- **Правильные ответы:** Такие же, как в макете-дизайне в Figma

# Структура #
```
app/src/main/java/com/example/labmedia/
    MainActivity.kt
    data/
        QuizRepository.kt
        model/
            Answer.kt
            Question.kt
            Quiz.kt
        remote/
            QuizApi.kt
    navigation/
        AppNavigation.kt
    ui/
        theme/
            Color.kt
            Theme.kt
            Type.kt
        start/
            StartScreen.kt
            StartViewModel.kt
        quiz/
            QuizScreen.kt
            QuizViewModel.kt
            QuestionCard.kt
        result/
            ResultScreen.kt
            ResultViewModel.kt
```
