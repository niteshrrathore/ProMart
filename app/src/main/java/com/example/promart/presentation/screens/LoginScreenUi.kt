package com.example.promart.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.promart.presentation.navigation.ScreenNavigation

private fun logged(username: String, password: String) {
    if (username == "jks" && password == "12345") {
        //Toast.makeText(this, "logged!!", Toast.LENGTH_SHORT).show()
    } else {
        //Toast.makeText(this, "wrong credential", Toast.LENGTH_SHORT).show()
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(NavHostController(context = LocalContext.current))
}

@Composable
fun LoginScreen(navHostController: NavHostController) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.Center,
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome Back", fontSize = 25.sp, color = Color.White,
                style = MaterialTheme.typography.caption, fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier
            .height(40.dp)
            .padding(20.dp))

        OutlinedTextField(
            value = username.value,
            onValueChange = {
                username.value = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                disabledBorderColor = Color.White,
                cursorColor = Color.Black
            ),
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person", tint = Color.White)
            },
            label = {
                Text(text = "Username", color = Color.White)
            },
            placeholder = {
                Text(text = "enter username")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                disabledBorderColor = Color.White,
                cursorColor = Color.Black
            ),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "person", tint = Color.White)
            },
            label = {
                Text(text = "Password", color = Color.White)
            },
            placeholder = {
                Text(text = "enter password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 30.dp, start = 20.dp, end = 20.dp)
        )

        OutlinedButton(
            onClick = { logged(username.value, password.value)
                        navHostController.navigate(ScreenNavigation.HomeScreen.route)
                      },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 10.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {
            Text(text = "Login")
        }
    }
}