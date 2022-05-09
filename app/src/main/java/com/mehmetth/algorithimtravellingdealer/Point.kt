package com.mehmetth.algorithimtravellingdealer

import android.util.Log
import kotlin.math.sqrt

class Point(var pointX: Int, private var pointY: Int) {
    private var nextLocaiton: Point? = null
    private lateinit var factory: Point

    fun setFactoryLocation(point: Point) {
        factory = point
    }

    fun setDestinationLocation(x: Int, y: Int) {
        val end = Point(x, y)
        var point: Point? = this
        while (point!!.nextLocaiton != null) {
            point = point.nextLocaiton
        }
        point.nextLocaiton = end
    }

    fun allPoints() {
        var point: Point? = this
        while (point != null) {
            Log.d("MainActivity","Point => ${point.pointX}  ${point.pointY}")
            point = point.nextLocaiton
        }
    }

    fun calculatePoints(): Int {
        var counter = 0
        var point: Point? = this
        while (point != null) {
            counter += 1
            point = point.nextLocaiton
        }

        return counter
    }

    fun distanceBetweenPoints(): Double {
        var totalDistanceForPoints = 0.0
        var point: Point? = this
        while (point != null) {
            val distance = sqrt((((point.pointX - factory.pointX) * (point.pointX - factory.pointX) + (point.pointY - factory.pointY) * (point.pointY - factory.pointY)).toDouble()))
            totalDistanceForPoints += distance
            point = point.nextLocaiton
            println(distance)
        }

        return totalDistanceForPoints
    }

    fun deletePointLocation(x: Int, y: Int): Point {
        var point: Point? = this
        var previousPoint: Point? = null

        while (point != null && (point.pointX == x).not() && (point.pointY == y).not()) {
            previousPoint = point
            point = point.nextLocaiton
        }

        if (point == null)
            println("ERROR")

        previousPoint!!.nextLocaiton = point!!.nextLocaiton

        return point
    }
}