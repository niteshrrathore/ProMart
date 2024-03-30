package com.example.promart.application

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.promart.navigation.ProMartNavigation

@Composable
fun ProMartApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {
        val navHostController = rememberNavController()
        ProMartNavigation(navHostController = navHostController)
    }
}