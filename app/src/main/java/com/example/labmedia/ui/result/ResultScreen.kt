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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocalFireDepartment
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
import com.example.labmedia.ui.theme.SuccessGreen
import com.example.labmedia.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
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
            Spacer(Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(DarkSurfaceVariant, RoundedCornerShape(6.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }
                Spacer(Modifier.size(8.dp))
                Text(
                    text = "Тест",
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = "Аттестация по информационной безопасности для сотрудников офиса",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = 26.sp
            )

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                InfoChip(text = "Максимальный балл: 320")
                InfoChip(text = "Проходной балл: 250")
            }

            Spacer(Modifier.height(24.dp))

            ResultCard()

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun ResultCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkSurface, RoundedCornerShape(24.dp))
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocalFireDepartment,
                contentDescription = null,
                tint = Color(0xFFFF3B30),
                modifier = Modifier.size(26.dp)
            )
            Spacer(Modifier.size(10.dp))
            Text(
                text = "Результат",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkSurfaceVariant, RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Баллы",
                        fontSize = 13.sp,
                        color = TextSecondary
                    )
                    Spacer(Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "1000",
                            fontSize = 44.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            lineHeight = 48.sp
                        )
                        Spacer(Modifier.size(12.dp))
                        Text(
                            text = "1000",
                            fontSize = 18.sp,
                            color = TextSecondary,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                }

                Spacer(Modifier.weight(1f))

                StatusBadge()
            }

            Spacer(Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.White.copy(alpha = 0.08f))
            )

            Spacer(Modifier.height(14.dp))

            DateRow(
                label = "Дата начала:",
                time = "08:00",
                date = "25 декабря 2024"
            )
            Spacer(Modifier.height(8.dp))
            DateRow(
                label = "Дата завершения:",
                time = "23:59",
                date = "25 декабря 2024"
            )
        }
    }
}

@Composable
private fun StatusBadge() {
    Row(
        modifier = Modifier
            .background(SuccessGreen.copy(alpha = 0.18f), RoundedCornerShape(20.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = SuccessGreen,
            modifier = Modifier.size(16.dp)
        )
        Spacer(Modifier.size(6.dp))
        Text(
            text = "выполнено",
            fontSize = 13.sp,
            color = SuccessGreen,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun DateRow(label: String, time: String, date: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = TextSecondary,
            modifier = Modifier.weight(1f)
        )
        Pill(text = time)
        Spacer(Modifier.size(6.dp))
        Pill(text = date)
    }
}

@Composable
private fun Pill(text: String) {
    Box(
        modifier = Modifier
            .background(Color.White.copy(alpha = 0.08f), RoundedCornerShape(6.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text = text,
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
            color = Color.White
        )
    }
}