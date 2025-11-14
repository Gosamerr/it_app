package com.example.it_app.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.it_app.model.Grade
import kotlinx.coroutines.flow.StateFlow
@Composable
fun ItScreen(
    grades:  List<Grade>,
    onAddGradeClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        Text(
            text = "Информатика — оценки",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        ) {
            Text(
                text = "Дата",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Тип работы",
                modifier = Modifier.weight(2f),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Оценка",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
        )

        Spacer(Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f, fill = true)
        ) {
            items(grades) { grade ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = grade.date,
                        modifier = Modifier.weight(1.4f)
                    )
                    Text(
                        text = grade.workType,
                        modifier = Modifier.weight(2f)
                    )
                    Text(
                        text = grade.value,
                        modifier = Modifier.weight(0.7f)
                    )
                }
            }
        }

        Spacer(Modifier.height(10.dp))

        Button(
            onClick = onAddGradeClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Text("Добавить оценку")
        }


    }
}
