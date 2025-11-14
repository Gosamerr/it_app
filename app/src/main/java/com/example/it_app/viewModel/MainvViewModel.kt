package com.example.it_app.viewModel
import androidx.lifecycle.ViewModel
import com.example.it_app.model.Student
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.it_app.model.Grade
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    val users = mutableStateListOf<Student>(
        Student(
            1,
            "loikliza4@gmail.com", "Лоик",
            "Елизавета", "Владиславовна", "По-31"
        )
    )
    var studentName by mutableStateOf("")
    var studentSurname by mutableStateOf("")
    var studentPartonymic by mutableStateOf("")
    var studentGroup by mutableStateOf("")


    fun changeName(value: String) {
        studentName = value
    }

    private val _grades = MutableStateFlow<List<Grade>>(
        listOf(
            Grade("01.09.2025", "Контрольная", "5"),
            Grade("10.09.2025", "Домашнее задание", "4"),
            Grade("20.09.2025", "Лабораторная", "5")
        ))
    val grades: StateFlow<List<Grade>> = _grades
    fun addGrade(date: String, workType: String, value: String) {
        _grades.update { oldList ->
            oldList + Grade(date, workType, value)
        }
    }
}