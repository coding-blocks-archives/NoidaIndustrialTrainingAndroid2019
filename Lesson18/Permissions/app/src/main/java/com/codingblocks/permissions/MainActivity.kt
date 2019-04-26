package com.codingblocks.permissions

import android.Manifest
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.content.PermissionChecker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Normal flow
        btnCall.setOnClickListener {

            val resultCall = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)

            if (resultCall == PermissionChecker.PERMISSION_GRANTED) {
                val callUri = "tel:${etNumber.text}"
                val callIntent = Intent(ACTION_CALL)
                callIntent.data = Uri.parse(callUri)

                startActivity(callIntent)
            } else if (resultCall == PermissionChecker.PERMISSION_DENIED) {
                //Request permissions
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    12345
                )
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 12345) {
            if (grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {

                val callUri = "tel:${etNumber.text}"
                val callIntent = Intent(ACTION_CALL)
                callIntent.data = Uri.parse(callUri)

                startActivity(callIntent)
            } else {
                Toast.makeText(this, "Please grant the permission to continue", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
