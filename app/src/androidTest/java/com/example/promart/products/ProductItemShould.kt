package com.example.promart.products

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.promart.model.Item
import com.example.promart.presentation.screens.ProductItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductItemShould {

    @get:Rule
    val composerule = createComposeRule()
    private lateinit var mItem : Item

    @Before
    fun setUp() {
        mItem = Item(id = 753342,"Galaxy F2 fold","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",650, "Samsung","Phone","guvgvucvgc")
        composerule.setContent {
            ProductItem(item = mItem)
        }
    }

    @Test
    fun beDispalyed(){
        composerule.onNodeWithTag("productItem").assertIsDisplayed()
    }

    @Test
    fun containCorrectTitle(){
        composerule.onNodeWithText("ProMart")
    }
}