package com.codingblocks.mapsapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolygonOptions

class MapsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync {

            val delhi = LatLng(28.70, 77.10)

            val markerOptionsDelhi = MarkerOptions().position(delhi)
                .title("Delhi")
                .draggable(true)
                .alpha(30f)

            it.addMarker(markerOptionsDelhi)

            val cameraUpdate = CameraUpdateFactory
                .newLatLngZoom(delhi, 15f)

//            it.moveCamera(cameraUpdate)

            it.animateCamera(cameraUpdate)


            it.setOnMapClickListener { latlng ->
                val newMarkerOptions = MarkerOptions().position(latlng)
                    .title("Delhi")
                    .draggable(true)
                    .alpha(30f)

                val marker = it.addMarker(newMarkerOptions)
                val update = CameraUpdateFactory
                    .newLatLngZoom(latlng, 15f)

//            it.moveCamera(cameraUpdate)

//                marker.remove()

                it.animateCamera(update)
            }

            it.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener{
                override fun onMarkerDragEnd(p0: Marker?) {
//                    val polyline = it.addPolyline(p0?.position)
                }

                override fun onMarkerDragStart(p0: Marker?) {


                }

                override fun onMarkerDrag(p0: Marker?) {

                }

            })

        }

    }

}
