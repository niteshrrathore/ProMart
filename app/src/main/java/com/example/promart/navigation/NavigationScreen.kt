package com.example.promart.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class NavigationScreen{

    object LoginScreen : NavigationScreen()
    object HomeScreen : NavigationScreen()
    /*object ThirdScreen : NavigationScreen("{data}/thirdscreen"){
        fun createRoute(data:String) = "$data/thirdscreen"
    }*/

}

object ProMartAppRouter {
    var currentScreen: MutableState<NavigationScreen> = mutableStateOf(NavigationScreen.LoginScreen)

    fun navigateTo(destination : NavigationScreen){
        currentScreen.value = destination
    }
}