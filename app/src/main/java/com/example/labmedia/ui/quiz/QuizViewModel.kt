package com.example.labmedia.ui.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labmedia.data.QuizRepository
import com.example.labmedia.data.model.Question
import com.example.labmedia.data.model.Quiz
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class QuizUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val quiz: Quiz? = null,
    val selectedAnswers: Map<String, String> = emptyMap()
) {
    val answeredCount: Int get() = selectedAnswers.size
    val totalCount: Int get() = quiz?.questions?.size ?: 0
    val remainingCount: Int get() = totalCount - answeredCount
    val allAnswered: Boolean get() = totalCount > 0 && answeredCount == totalCount
}

class QuizViewModel(
    private val repository: QuizRepository = QuizRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    init {
        loadQuiz()
    }

    fun loadQuiz() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            repository.getQuiz()
                .onSuccess { quiz ->
                    _uiState.update {
                        it.copy(isLoading = false, quiz = quiz, error = null)
                    }
                }
                .onFailure { e ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = e.message ?: "Неизвестная ошибка"
                        )
                    }
                }
        }
    }

    fun selectAnswer(questionId: String, answerId: String) {
        _uiState.update { state ->
            state.copy(
                selectedAnswers = state.selectedAnswers + (questionId to answerId)
            )
        }
    }
}
