package com.codingblocks.cameraview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.otaliastudios.cameraview.CameraException
import com.otaliastudios.cameraview.CameraListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraView.addCameraListener(object : CameraListener() {
            override fun onPictureTaken(jpeg: ByteArray?) {
                super.onPictureTaken(jpeg)
                Log.e("TAG", "Picture taken!")
            }
        })

        cameraView.setOnClickListener {

            cameraView.captureSnapshot()

        }
    }

    override fun onStart() {
        super.onStart()
        cameraView.start()
    }

    override fun onStop() {
        super.onStop()
        cameraView.stop()
    }

}
