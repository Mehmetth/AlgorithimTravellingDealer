package com.mehmetth.algorithimtravellingdealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    var point : Point? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        point = Point(1, 4)
        point!!.setFactoryLocation(Point(3, 7))

        point!!.setDestinationLocation(1, 10)
        point!!.setDestinationLocation(2, 1)
        point!!.setDestinationLocation(5, 2)
        point!!.setDestinationLocation(6, 5)
        point!!.setDestinationLocation(8, 4)
        point!!.setDestinationLocation(8, 9)
        point!!.setDestinationLocation(9, 2)

        val distanceBetweenPoints = point!!.distanceBetweenPoints()
        Log.d("MainActivity","Distance Between Points:$distanceBetweenPoints")

        Log.d("MainActivity","++++++++++++++++++++++++++++++++++++++++++++++")

        Log.d("MainActivity","Point length: ${point!!.calculatePoints()}")

        Log.d("MainActivity","++++++++++++++++++++++++++++++++++++++++++++++")
        point!!.deletePointLocation(5, 2)
        Log.d("MainActivity","++++++++++++++++++++++++++++++++++++++++++++++")

        Log.d("MainActivity","(5,2) Point After Deleted")
        point!!.allPoints()
    }
}