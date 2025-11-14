// например StudentDto из model

package com.example.it_app.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.it_app.R
import com.example.it_app.model.Student

@Composable
fun ProfileScreen(
    student: Student,
    onNavigateToIt: () -> Unit
) {
    val textStyle = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        color = Color.DarkGray
    )

    val textStyle2 = TextStyle(
        fontSize = 30.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        color = colorResource(R.color.teal_700)
    )

    Column(
        modifier = Modifier.height(550.dp).padding(20.dp, 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "Имя ${student.name}", style = textStyle)
        Text(text = "Фамилия ${student.surname}", style = textStyle)
        Text(text = "Отчество ${student.patronymic ?: ""}", style = textStyle)
        Text(text = "Группа ${student.group}", style = textStyle)

        Box(
            modifier = Modifier
                .size(300.dp, 10.dp)
                .background(colorResource(R.color.teal_700))
        )

        Text(
            text = "Информатика",
            style = textStyle2,
            modifier = Modifier.clickable { onNavigateToIt() }
        )
    }
}
