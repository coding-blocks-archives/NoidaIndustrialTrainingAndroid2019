package com.codingblocks.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater

class MainActivity : AppCompatActivity(), SensorEventListener {

    private val sensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val li = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val sensorList =
            sensorManager.getSensorList(Sensor.TYPE_ALL)

        Log.e("TAG", "Number of sensors ${sensorList.size}")

        sensorList.forEach {
            Log.e("TAG", it.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        val gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        val proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        sensorManager.registerListener(this, gravitySensor, 1000000)
        sensorManager.registerListener(this, proximitySensor, 1000000)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            when (it.sensor.type) {
                Sensor.TYPE_PROXIMITY -> {
                    Log.e("TAG", "Value from proximity sensor is of size: ${it.values.size}")
                }

                Sensor.TYPE_GRAVITY -> {
                    Log.e("TAG", "Gravity in x : ${it.values[0]}")
                    Log.e("TAG", "Gravity in y : ${it.values[1]}")
                    Log.e("TAG", "Gravity in z : ${it.values[2]}")
//                    Log.e("TAG", "Value from gravity sensor is of size: ${it.values.size}")
                }

                else -> {
                    Log.e("TAG", "Incompatible sensor found!")
                }
            }
        }
//        if (event != null) {
//
//        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Called when the state of the device is changed
        // which could affect the sensor you use
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(this)
    }

}
