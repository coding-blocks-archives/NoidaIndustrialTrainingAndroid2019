package com.codingblocks.notesfirebase

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_dialog.view.*

class MainActivity : AppCompatActivity() {

    private val dialogView by lazy {
        layoutInflater.inflate(R.layout.layout_dialog, null, false)
    }

    private val loginAlert by lazy {
        AlertDialog.Builder(this)
            .setTitle("Please sign up or login to use the app")
            .setView(dialogView)
            .setPositiveButton("Login") { dialog, _ ->

                val email = dialogView.etEmail.text.toString()
                val password = dialogView.etPassword.text.toString()

                startLoginWithEmailAndPassword(email, password)
                dialog.dismiss()
            }
            .setNeutralButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Sign Up") { dialog, _ ->
                val email = dialogView.etEmail.text.toString()
                val password = dialogView.etPassword.text.toString()

                startSignUpWithEmailAndPassword(email, password)
                dialog.dismiss()
            }
            .create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAddNote.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            loginAlert.show()
        }

        val button = Button(this)

        button.setOnClickListener {
            FirebaseAuth.getInstance()
                // This authStateListener callback is called
                // everytime the user logs in or logs out
                .addAuthStateListener {
                    it.currentUser?.let {
                        //Add listener to your database

                    } ?: run {
                        //sign up/login
                        loginAlert.show()
                    }
                }
        }


//        val firebaseUser: FirebaseUser? = null
//
//        //The let block will only run iff the firebaseUser variable isn't null
//        firebaseUser?.let {
//            it.isAnonymous
//            it.displayName
//            it.email
//        } ?: run {
//            Toast.makeText(this, "User is null", Toast.LENGTH_SHORT).show()
//        }
//
//        val name = firebaseUser?.displayName ?: "Name Not Found"
//        firebaseUser?.email
//        firebaseUser?.isAnonymous
//

//        FirebaseAuth.getInstance()
//            .currentUser?.let {
//            // This will run when the user is logged in
//            // Continue with your normal work flow
//            // Listener
//            Toast.makeText(this, "Welcome back ${it.email}", Toast.LENGTH_SHORT).show()
//        } ?: run {
//            // This will run when the user is logged out
//            // Prompt a sign in
//            showLoginAlert()
//        }

    }

    private fun startSignUpWithEmailAndPassword(
        email: String,
        password: String
    ) {

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                Log.e("TAG", "Email : ${it.user.email}")
                Log.e("TAG", "UID : ${it.user.uid}")
                Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                it.printStackTrace()
                Toast.makeText(this, "Signup Failed!", Toast.LENGTH_SHORT).show()
            }
            .addOnCompleteListener {

            }
    }

    private fun startLoginWithEmailAndPassword(
        email: String,
        password: String
    ) {

        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                Log.e("TAG", "Email : ${it.user.email}")
                Log.e("TAG", "UID : ${it.user.uid}")
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                it.printStackTrace()
            }
            .addOnCompleteListener {

            }
    }

}
