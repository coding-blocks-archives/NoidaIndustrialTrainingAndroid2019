package com.codingblocks.menus

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.menu_about -> {
                Toast.makeText(this, "About item clicked", Toast.LENGTH_SHORT).show()
            }

            R.id.menu_help -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:9968195588")
                startActivity(intent)
            }

            R.id.menu_settings -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
