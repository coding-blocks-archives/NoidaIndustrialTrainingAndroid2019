package com.codingblocks.customtoast

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.widget.Toast

class CustomToast {

    companion object {
        fun showCustomToast(ctx: Context, @LayoutRes layout: Int) {
            val toast = Toast(ctx)
            val inflater = LayoutInflater.from(ctx)
            toast.view = inflater.inflate(layout, null, false)
            toast.show()
        }
    }
}