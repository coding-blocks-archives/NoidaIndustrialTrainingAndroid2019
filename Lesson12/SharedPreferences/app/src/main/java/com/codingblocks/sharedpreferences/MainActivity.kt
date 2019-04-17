package com.codingblocks.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //You can also attach a listener to your shared Preferences
        //to get updates on the changes item
//        sharedPreferences.registerOnSharedPreferenceChangeListener {
//                sharedPreferences: SharedPreferences,
//                key: String ->
//        }

        btnCount.setOnClickListener {
            tvCount.text = (++count).toString()
        }
    }


    override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences(
            "my_preferences.xml",
            Context.MODE_PRIVATE
        )
        count = sharedPreferences.getInt("KEY", 0)
        tvCount.text = count.toString()
    }

    override fun onStop() {
        super.onStop()

        val sharedPreferences = getSharedPreferences(
            "my_preferences.xml",
            Context.MODE_PRIVATE
        )

        val editor = sharedPreferences.edit()

        editor.putInt("KEY", count)
        editor.putInt("VALUE", 44)
        editor.putString("XYZ", "HELLO")

        //apply() saves the changes asynchronously whereas
        //commit() does them synchronously
        editor.apply()
    }

}
