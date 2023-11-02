package com.ps4_pum.utils

object GeometryCalculations {
    fun calculateSquareArea(side: Double): Double = side * side

    fun calculateRectangleArea(length: Double, width: Double): Double = length * width

    fun calculateTriangleArea(base: Double, height: Double): Double = (base * height) / 2

    fun calculateRhombusArea(diagonal1: Double, diagonal2: Double): Double = (diagonal1 * diagonal2) / 2

    fun calculateTrapezoidArea(base1: Double, base2: Double, height: Double): Double =
        ((base1 + base2) * height) / 2

    fun calculateCircleArea(radius: Double): Double = Math.PI * radius * radius
}