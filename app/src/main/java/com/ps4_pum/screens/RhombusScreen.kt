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
fun RhombusScreen(navController: NavController) {
    var diagonal1 by remember { mutableStateOf("") }
    var diagonal2 by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        area?.let {
            Text("Pole rombu: $it", style = MaterialTheme.typography.h5)
        }

        TextField(
            value = diagonal1,
            onValueChange = { diagonal1 = it },
            label = { Text("Przekątna 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = diagonal2,
            onValueChange = { diagonal2 = it },
            label = { Text("Przekątna 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = diagonal1.toDoubleOrNull()?.let { d1 ->
                    diagonal2.toDoubleOrNull()?.let { d2 ->
                        GeometryCalculations.calculateRhombusArea(d1, d2)
                    }
                }
            }
        ) {
            Text("Oblicz pole rombu")
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