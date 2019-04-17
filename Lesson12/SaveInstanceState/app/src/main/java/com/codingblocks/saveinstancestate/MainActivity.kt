package com.codingblocks.saveinstancestate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0
    lateinit var harshit: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            harshit = Student("Harshit", 23, "Delhi")
            tvCount.text = (++count).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val gson = Gson()

        outState?.putInt("KEY", count)
        outState?.putString("STUDENT", gson.toJson(harshit))
    }

    //These two methods are called when the activity was killed but the
    //app user didn't intend to do so
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val gson = Gson()
//        if (savedInstanceState == null) {
//            count = 0
//        } else {
//            count = savedInstanceState.getInt("KEY")
//        }

        //Elvis operator is used to perform an operation that happens
        //when the operand is null
        count = savedInstanceState?.getInt("KEY") ?: 0

        val stringStudent =
            savedInstanceState?.getString("STUDENT")

        harshit = gson.fromJson(stringStudent, Student::class.java)

        tvCount.text = count.toString()
    }

}
