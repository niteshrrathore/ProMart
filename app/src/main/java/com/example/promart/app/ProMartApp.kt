package com.example.promart.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.promart.navigation.NavigationScreen
import com.example.promart.navigation.ProMartAppRouter
import com.example.promart.view.HomeScreen
import com.example.promart.view.LoginScreen

@Composable
fun ProMartApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Crossfade(targetState = ProMartAppRouter.currentScreen, label = "ProMart") { currentState ->
            when(currentState.value) {
                is NavigationScreen.LoginScreen ->{
                    LoginScreen()
                }
                is NavigationScreen.HomeScreen ->{
                    HomeScreen()
                }
            }
        }
    }
}