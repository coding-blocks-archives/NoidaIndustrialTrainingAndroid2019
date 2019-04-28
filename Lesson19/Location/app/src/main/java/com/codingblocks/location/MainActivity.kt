package com.codingblocks.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.PermissionChecker
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val providers = locationManager.allProviders
//
//        //Check for the availibility of providers
//        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//
//        } else {
//            //Show alert asking the user to enable their location
//        }
    }

    override fun onStart() {
        super.onStart()
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PermissionChecker.PERMISSION_GRANTED
        ) {
            getLocationUpdates()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                12345
            )
        }
    }

    @SuppressLint("MissingPermission")
    fun getSingleLocation() {
        val locationManager = getSystemService(Context.LOCATION_SERVICE)
                as LocationManager

        locationManager.requestSingleUpdate(
            LocationManager.GPS_PROVIDER,
            object : LocationListener {
                override fun onLocationChanged(location: Location?) {

                }

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onProviderEnabled(provider: String?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onProviderDisabled(provider: String?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            },
            null
        )

    }

    @SuppressLint("MissingPermission")
    fun getLocationUpdates() {
        val locationManager = getSystemService(Context.LOCATION_SERVICE)
                as LocationManager
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
            1000,
            10F,
            object : LocationListener {

                override fun onLocationChanged(location: Location?) {

//                    val location = Location(LocationManager.GPS_PROVIDER).apply {
//                        latitude = 27.12
//                        longitude = 92.13
//                    }
//
//                    val location = Location(LocationManager.GPS_PROVIDER)
//                    location.longitude = 92.13
//                    location.latitude = 27.12

                    location?.let {
                        Log.e("TAG", "Latitude is ${it.latitude}")
                        Log.e("TAG", "Longitude is ${it.longitude}")
                        Log.e("TAG", "Speed is ${it.speed}")
                        Log.e("TAG", "Accuracy is ${it.accuracy}")
                        Log.e("TAG", "Time is ${it.time}")
                        Log.e("TAG", "Altitude is ${it.altitude}")
                        Log.e("TAG", "Provider is ${it.provider}")
                        Log.e("TAG", "Bearing is ${it.bearing}")
                    }
                }

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                }

                override fun onProviderEnabled(provider: String?) {
                }

                override fun onProviderDisabled(provider: String?) {
                }

            })
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 12345) {
            if (grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {
                getLocationUpdates()
            } else {
                Toast.makeText(this, "Please grant permissions", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }

}
