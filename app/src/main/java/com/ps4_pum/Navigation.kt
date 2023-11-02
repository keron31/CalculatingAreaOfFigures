package com.ps4_pum

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ps4_pum.screens.*
import androidx.compose.animation.*
import androidx.navigation.*

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GeometryCalculatorNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            AnimatedComposable() {
                HomeScreen(navController)
            }
        }
        composable("square") {
            AnimatedComposable() {
                SquareScreen(navController)
            }
        }
        composable("rectangle") {
            AnimatedComposable() {
                RectangleScreen(navController)
            }
        }
        composable("triangle") {
            AnimatedComposable() {
                TriangleScreen(navController)
            }
        }
        composable("rhombus") {
            AnimatedComposable() {
                RhombusScreen(navController)
            }
        }
        composable("trapezoid") {
            AnimatedComposable() {
                TrapezoidScreen(navController)
            }
        }
        composable("circle") {
            AnimatedComposable() {
                CircleScreen(navController)
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimatedComposable(
    content: @Composable () -> Unit
) {
    val transitionState = remember { MutableTransitionState(false) }.apply { targetState = true }
    val enterTransition: EnterTransition = slideInVertically(
        initialOffsetY = { fullHeight -> fullHeight },
        animationSpec = tween(durationMillis = 100)
    ) + fadeIn(animationSpec = tween(durationMillis = 100))

    val exitTransition: ExitTransition = slideOutVertically(
        targetOffsetY = { fullHeight -> fullHeight },
        animationSpec = tween(durationMillis = 100)
    ) + fadeOut(animationSpec = tween(durationMillis = 100))

    AnimatedVisibility(
        visibleState = transitionState,
        enter = enterTransition,
        exit = exitTransition
    ) {
        content()
    }
}