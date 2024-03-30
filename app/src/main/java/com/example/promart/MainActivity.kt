package com.example.promart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.promart.application.ProMartApp
import com.example.promart.ui.theme.ProMartTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProMartTheme {
                Surface(color = MaterialTheme.colors.primary) {
                    ProMartApp()
                }
            }
        }
    }
}

