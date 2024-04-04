package com.example.promart.products

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.promart.presentation.MainActivity
import org.junit.Rule
import org.junit.Test

class ProductsFeature {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun validateProgressBarVisible(){
        composeRule.apply{
            onNodeWithTag("progress").assertIsDisplayed()
        }
    }

    @Test
    fun validateIsProductVisible(){
        composeRule.apply{
            Thread.sleep(2000)
            onNodeWithTag("products").assertIsDisplayed()
        }
    }

}