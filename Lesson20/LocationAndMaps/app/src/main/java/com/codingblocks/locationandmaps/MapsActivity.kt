package com.codingblocks.locationandmaps

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), LocationListener {

    lateinit var googleMap: GoogleMap

    var lastKnownLatLng: LatLng? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        locationManager.allProviders.forEach {
            Log.e("TAG", it)
        }

        mapFragment.getMapAsync {
            googleMap = it

            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000,
                10F,
                this
            )
        }

        //Retrieving the location
        //Load the map and show that location on the map
    }

    override fun onLocationChanged(location: Location?) {
        location?.let {
            lastKnownLatLng?.let {

                //Draw a polyline between lastknownlatlng and current latlng
                //lastknownlatlng = currentLatlng
            } ?: run {

                //lastknownlatlng = currentlatlng
                //add marker at the currentlatlng
            }
        }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }

//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//    }
}
