package com.example.promart.presentation.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class ScreenNavigation(val route : String){

    object LoginScreen : ScreenNavigation("login")
    object HomeScreen : ScreenNavigation("home")
    /*object ThirdScreen : NavigationScreen("{data}/thirdscreen"){
        fun createRoute(data:String) = "$data/thirdscreen"
    }*/

}