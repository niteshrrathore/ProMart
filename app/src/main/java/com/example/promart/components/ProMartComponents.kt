package com.example.promart.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun TextSubtitle(txt:String){
    Text(
        text = txt,
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TextHeadingBold(txt:String){
    Text(
        text = txt,
        color = MaterialTheme.colors.primaryVariant,
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TextBodyEllipsis(txt:String){
    Text(
        text = txt,
        style = MaterialTheme.typography.body1,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

/*@Composable
fun ProMartTextField(labelValue:String, placeHolder:String){

    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        value = textValue,
        onValueChange = {
            textValue.value = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            focusedLabelColor = Color.White,
            cursorColor = MaterialTheme.colors.primary
        ),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = {
            Icon(Icons.Default.Person, contentDescription = "person")
        },
        label = {
            Text(text = labelValue)
        },
        placeholder = {
            Text(placeHolder)
        },
        modifier = Modifier.fillMaxWidth()
    )
}*/
