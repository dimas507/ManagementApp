package com.mccm.managementapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultOutlinedTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    validateField: () -> Unit = {},
    label: String,
    icon: ImageVector? = null,
    painter: Painter? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false,
    errorMsg: String = "",
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(Color.Black)
    ){
    Column() {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = {
                onValueChange(it)
                validateField()},
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            label = { Text(label) },
            trailingIcon = {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = ""
                    )
                } else if (painter != null) {
                    Icon(
                        painter = painter,
                        contentDescription = ""
                    )
                }
            },
            visualTransformation =
            if (hideText) PasswordVisualTransformation()
            else VisualTransformation.None,
            colors = colors
        )
        Text(
            modifier=Modifier.padding(start = 20.dp),
            text = errorMsg,
            fontSize = 11.sp,
            color = Color.Red)
    }

}