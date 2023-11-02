package com.ps4_pum.screens

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ps4_pum.utils.GeometryCalculations

@Composable
fun RectangleScreen(navController: NavController) {
    var length by remember { mutableStateOf("") }
    var width by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        area?.let {
            Text(
                "Pole prostokąta: $it",
                style = MaterialTheme.typography.h5
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = length,
            onValueChange = { length = it },
            label = { Text("Długość") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = width,
            onValueChange = { width = it },
            label = { Text("Szerokość") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                area = length.toDoubleOrNull()?.let { len ->
                    width.toDoubleOrNull()?.let { wid ->
                        GeometryCalculations.calculateRectangleArea(len, wid)
                    }
                }
            }
        ) {
            Text("Oblicz pole prostokąta")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Powrót")
        }
    }
}