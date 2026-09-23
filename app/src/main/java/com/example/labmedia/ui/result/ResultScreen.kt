package com.example.labmedia.ui.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labmedia.ui.theme.DarkSurface
import com.example.labmedia.ui.theme.DarkSurfaceVariant
import com.example.labmedia.ui.theme.ErrorRed
import com.example.labmedia.ui.theme.SuccessGreen
import com.example.labmedia.ui.theme.TextSecondary
import com.example.labmedia.ui.theme.Yellow
import androidx.compose.material.icons.filled.LocalFireDepartment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    quizTitle: String,
    result: QuizResult,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Результат", fontWeight = FontWeight.Medium) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                    navigationIconContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(Modifier.height(8.dp))

            Text(
                text = quizTitle,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                InfoChip(text = "Максимальный балл: ${result.maxScore}")
                InfoChip(text = "Проходной балл: ${result.passingScore}")
            }

            Spacer(Modifier.height(20.dp))

            ResultCard(result = result)

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun ResultCard(result: QuizResult) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkSurface, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocalFireDepartment,
                contentDescription = null,
                tint = Color(0xFFFF5A3C),
                modifier = Modifier.size(22.dp)
            )
            Spacer(Modifier.size(8.dp))
            Text(
                text = "Результат",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkSurfaceVariant, RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Баллы",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                    Spacer(Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = result.score.toString(),
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(Modifier.size(8.dp))
                        Text(
                            text = "/ ${result.maxScore}",
                            fontSize = 16.sp,
                            color = TextSecondary,
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                    }
                }

                Spacer(Modifier.weight(1f))

                StatusBadge(passed = result.passed)
            }

            Spacer(Modifier.height(16.dp))

            DateRow(label = "Дата начала:", time = result.startedAt)
            Spacer(Modifier.height(6.dp))
            DateRow(label = "Дата завершения:", time = result.finishedAt)
        }
    }
}

@Composable
private fun StatusBadge(passed: Boolean) {
    val color = if (passed) SuccessGreen else ErrorRed
    val label = if (passed) "выполнено" else "не пройден"

    Row(
        modifier = Modifier
            .background(color.copy(alpha = 0.2f), RoundedCornerShape(20.dp))
            .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(14.dp)
        )
        Spacer(Modifier.size(4.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            color = color,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun DateRow(label: String, time: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = TextSecondary,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = time,
            fontSize = 12.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun InfoChip(text: String) {
    Box(
        modifier = Modifier
            .background(DarkSurfaceVariant, RoundedCornerShape(20.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            color = TextSecondary
        )
    }
}
