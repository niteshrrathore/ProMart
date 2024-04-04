package com.example.promart.presentation.navigation

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.staticCompositionLocalOf


private val LocalBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcherOwner?> {null}

private class ComposableBackNavigationHandler(enable : Boolean) : OnBackPressedCallback(enable) {

    lateinit var onBackPressed: () -> Unit

    override fun handleOnBackPressed() {
        onBackPressed()
    }

}