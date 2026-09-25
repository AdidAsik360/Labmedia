package com.example.labmedia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labmedia.ui.quiz.QuizScreen
import com.example.labmedia.ui.quiz.QuizViewModel
import com.example.labmedia.ui.result.ResultScreen
import com.example.labmedia.ui.result.ResultViewModel
import com.example.labmedia.ui.start.StartScreen

object Routes {
    const val START = "start"
    const val QUIZ = "quiz"
    const val RESULT = "result"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val quizViewModel: QuizViewModel = viewModel()
    val resultViewModel: ResultViewModel = viewModel()

    val state by quizViewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Routes.START
    ) {
        composable(Routes.START) {
            StartScreen(
                state = state,
                onStartClick = {
                    quizViewModel.restart()
                    navController.navigate(Routes.QUIZ)
                },
                onRetry = { quizViewModel.loadQuiz() },
                onBack = { }
            )
        }

        composable(Routes.QUIZ) {
            QuizScreen(
                state = state,
                onAnswerSelected = quizViewModel::selectAnswer,
                onRetry = { quizViewModel.loadQuiz() },
                onFinish = { navController.navigate(Routes.RESULT) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.RESULT) {
            val quiz = state.quiz
            val answers = state.selectedAnswers

            if (quiz != null) {
                val result = remember(quiz, answers) {
                    resultViewModel.calculate(quiz, answers)
                }

                ResultScreen(
                    onBack = {
                        navController.popBackStack(Routes.START, inclusive = false)
                    }
                )
            }
        }
    }
}