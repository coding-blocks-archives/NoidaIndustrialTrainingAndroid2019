package com.codingblocks.lambdas

import kotlinx.android.synthetic.main.activity_main.*

fun startCount(input: Long, func: (String) -> Unit) {

    Thread(Runnable {
        for (i in 0..input) {
        }
        func("Counting Done")
    }).start()
}

fun makeNetworkCallAndReturnList(cb: (List<String>) -> Unit) {

    cb(listOf("Hello"))

}