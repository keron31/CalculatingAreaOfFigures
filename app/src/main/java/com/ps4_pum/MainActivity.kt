package com.ps4_pum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ps4_pum.ui.theme.GeometryCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeometryCalculatorTheme {
                GeometryCalculatorNavHost()
            }
        }
    }
}
