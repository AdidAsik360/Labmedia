package com.example.labmedia.ui.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labmedia.data.model.Answer
import com.example.labmedia.data.model.Question
import com.example.labmedia.ui.theme.DarkSurface
import com.example.labmedia.ui.theme.SuccessGreen
import com.example.labmedia.ui.theme.TextSecondary
import com.example.labmedia.ui.theme.Yellow

@Composable
fun QuestionCard(
    number: Int,
    question: Question,
    selectedAnswerId: String?,
    onAnswerSelected: (answerId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkSurface, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(Modifier.size(8.dp))

            Box(
                modifier = Modifier
                    .border(1.dp, TextSecondary, RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Баллы за вопрос: ${question.weight}",
                    color = TextSecondary,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.weight(1f))

            if (selectedAnswerId != null) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = SuccessGreen,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        Text(
            text = question.text,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            question.answers.forEach { answer ->
                AnswerOption(
                    answer = answer,
                    isSelected = answer.id == selectedAnswerId,
                    onClick = { onAnswerSelected(answer.id) }
                )
            }
        }
    }
}

@Composable
private fun AnswerOption(
    answer: Answer,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isSelected) Yellow.copy(alpha = 0.15f) else Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = if (isSelected) 1.dp else 1.dp,
                color = if (isSelected) Yellow else MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(18.dp)
                .border(
                    width = 2.dp,
                    color = if (isSelected) Yellow else TextSecondary,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .size(9.dp)
                        .background(Yellow, CircleShape)
                )
            }
        }

        Spacer(Modifier.size(12.dp))

        Text(
            text = answer.text,
            color = if (isSelected) Color.White else TextSecondary,
            fontSize = 14.sp
        )
    }
}
