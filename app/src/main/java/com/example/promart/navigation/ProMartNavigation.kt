package com.example.promart.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.promart.view.HomeScreen
import com.example.promart.view.LoginScreen

@Composable
fun ProMartNavigation(navHostController: NavHostController) {

NavHost(navController = navHostController, startDestination = ScreenNavigation.LoginScreen.route){
    composable(ScreenNavigation.LoginScreen.route){
        LoginScreen(navHostController)
    }

    composable(ScreenNavigation.HomeScreen.route){
        HomeScreen(navHostController)
    }
}

}