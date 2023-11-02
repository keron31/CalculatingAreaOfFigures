package com.ps4_pum.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Wybierz figurę, której pole chcesz obliczyć",
                style = MaterialTheme.typography.h4.copy(textAlign = TextAlign.Center),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(30.dp))

            val buttonWidth = Modifier.width(200.dp)

            Button(
                onClick = { navController.navigate("square") },
                modifier = buttonWidth
            ) {
                Text("Oblicz pole kwadratu")
            }
            Button(
                onClick = { navController.navigate("rectangle") },
                modifier = buttonWidth
            ) {
                Text("Oblicz pole prostokąta")
            }
            Button(
                onClick = { navController.navigate("triangle") },
                modifier = buttonWidth
            ) {
                Text("Oblicz pole trójkąta")
            }
            Button(
                onClick = { navController.navigate("rhombus") },
                modifier = buttonWidth
            ) {
                Text("Oblicz pole rombu")
            }
            Button(
                onClick = { navController.navigate("trapezoid") },
                modifier = buttonWidth
            ) {
                Text("Oblicz pole trapeza")
            }
            Button(
                onClick = { navController.navigate("circle") },
                modifier = buttonWidth
            ) {
                Text("Oblicz pole koła")
            }
        }
    }
}