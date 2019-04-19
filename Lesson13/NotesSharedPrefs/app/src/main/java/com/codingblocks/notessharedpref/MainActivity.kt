package com.codingblocks.notessharedpref

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() {

    //by lazy { } initializes the variables lazily; i.e.
    //they are only initialized when they are called for the first time
    private val sharedPreferences by lazy {
        getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAddNote.setOnClickListener {
            showComplexAlert()
        }

        val result = sharedPreferences.getString(
            "KEY",
            "KEY NOT FOUND!"
        )

        sharedPreferences.edit()
            .putString("KEY", "KEY EXISTS")
            .putBoolean("BOOL",true)
            .putInt("COUNT",5)
            .apply()

        sharedPreferences.edit()
            .remove("abc")
            .apply()

        //Start intent for the login activity
    }

    override fun onStart() {
        super.onStart()
        sharedPreferences.all.forEach {
            Log.e("TAG", "Key is ${it.key}")
            Log.e("TAG", "Value is ${it.value}")

            val note = Note(it.key, it.value.toString())
            //Add this note to your data source
            //Call notifyItemInserted/notifyDatasetChanged on the adapter
        }
    }

    private fun showComplexAlert() {

        val dialogView = layoutInflater.inflate(
            R.layout.view_dialog,
            null,
            false
        )

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Hello from an Alert Dialog!")
            .setView(dialogView)
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, which ->
                val note = dialogView.etUserName.text.toString()

                //This line of code saves the input provided by the user with the current
                //epoch timestamp as its key
                sharedPreferences.edit().putString(
                    System.currentTimeMillis().toString(),
                    note
                ).apply()

                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            .create()

        alertDialog.show()

    }

}
