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
fun TrapezoidScreen(navController: NavController) {
    var base1 by remember { mutableStateOf("") }
    var base2 by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        area?.let {
            Text("Pole trapezu: $it", style = MaterialTheme.typography.h5)
        }

        TextField(
            value = base1,
            onValueChange = { base1 = it },
            label = { Text("Podstawa 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = base2,
            onValueChange = { base2 = it },
            label = { Text("Podstawa 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Wysokość") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                area = base1.toDoubleOrNull()?.let { b1 ->
                    base2.toDoubleOrNull()?.let { b2 ->
                        height.toDoubleOrNull()?.let { h ->
                            GeometryCalculations.calculateTrapezoidArea(b1, b2, h)
                        }
                    }
                }
            }
        ) {
            Text("Oblicz pole trapezu")
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