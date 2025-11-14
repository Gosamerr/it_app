package com.example.it_app.navigation
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.it_app.ui.profile.ProfileScreen
import androidx.navigation.compose.composable
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.it_app.viewModel.MainViewModel
import androidx.compose.runtime.collectAsState
import com.example.it_app.viewModel.MainViewModel
import com.example.it_app.model.Grade
import com.example.it_app.ui.profile.ItScreen

sealed class Routes(val route: String) {
    object Profile : Routes("profile")
    object It : Routes("it")
    object Loading : Routes("loading")
}

@Composable
fun NavigationApp(
    navController: NavHostController,
    vm: MainViewModel = viewModel()
) {

    NavHost(navController = navController, startDestination = Routes.Profile.route) {

        composable(Routes.Profile.route) {
            val student = vm.users[0]
            ProfileScreen(
                student = student,
                onNavigateToIt = { navController.navigate(Routes.It.route) }
            )
        }

        composable(Routes.It.route) {
            val grades by vm.grades.collectAsState()
            ItScreen(
                grades = grades,
                onAddGradeClick = { vm.addGrade(
                    date = "13.11.2025",
                    workType = "Тест",
                    value = "5") })
        }
    }
}

