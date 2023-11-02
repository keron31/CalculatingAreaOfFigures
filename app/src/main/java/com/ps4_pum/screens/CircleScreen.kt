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
fun CircleScreen(navController: NavController) {
    var radius by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        area?.let {
            Text("Pole koła: ${String.format("%.2f", it)}", style = MaterialTheme.typography.h5)
        }

        TextField(
            value = radius,
            onValueChange = { radius = it },
            label = { Text("Promień") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = radius.toDoubleOrNull()?.let { r ->
                    GeometryCalculations.calculateCircleArea(r)
                }
            }
        ) {
            Text("Oblicz pole koła")
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