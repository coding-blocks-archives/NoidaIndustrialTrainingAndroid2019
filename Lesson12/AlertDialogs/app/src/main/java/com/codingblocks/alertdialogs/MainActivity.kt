package com.codingblocks.alertdialogs

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSimpleAlert.setOnClickListener {
            showSimpleAlert()
        }

        btnComplexAlert.setOnClickListener {
            showComplexAlert()
        }

        btnListAlert.setOnClickListener {
            showListAlert()
        }

        btnRadioAlert.setOnClickListener {
            showRadioAlert()
        }

        btnCheckAlert.setOnClickListener {
            showCheckBoxAlert()
        }
    }

    private fun showCheckBoxAlert() {
//        val itemArray = arrayOf("Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
//
//        val alertDialog = AlertDialog.Builder(this)
//            .setTitle("Hello from an Alert Dialog!")
//            .setMultiChoiceItems(
//                itemArray,
//                arrayOf(true,false,false,true,true,true),
//                DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked -> })
//            .setNegativeButton("Cancel") { dialog, which ->
//                dialog.dismiss()
//            }
//            .setCancelable(false)
//            .create()
//
//        alertDialog.show()
    }

    private fun showRadioAlert() {
        val itemArray = arrayOf("Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Hello from an Alert Dialog!")
            .setSingleChoiceItems(itemArray, 0) { dialog, position ->
                Toast.makeText(
                    this,
                    "You selected ${itemArray[position]}",
                    Toast.LENGTH_SHORT
                ).show()
//                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .create()

        alertDialog.show()
    }

    private fun showListAlert() {

        val itemArray = arrayOf("Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Hello from an Alert Dialog!")
            .setItems(itemArray) { dialog, position ->
                Toast.makeText(
                    this,
                    "You selected ${itemArray[position]}",
                    Toast.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .create()

        alertDialog.show()
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
                Toast.makeText(
                    this,
                    "Thank you ${dialogView.etUserName.text} for clicking the yes button",
                    Toast.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, which ->
                Toast.makeText(
                    this,
                    "Thank you ${dialogView.etUserName.text} for clicking the No button",
                    Toast.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }
            .create()

        alertDialog.show()

    }

    private fun showSimpleAlert() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Hello from an Alert Dialog!")
            .setMessage("How are you doing today?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, which ->
                Toast.makeText(this, "Thank you for clicking the yes button", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, which ->
                Toast.makeText(this, "Thank you for clicking the No button", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .create()

        alertDialog.show()
    }

}
