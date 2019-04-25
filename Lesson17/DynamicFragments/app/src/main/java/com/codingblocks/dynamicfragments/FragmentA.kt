package com.codingblocks.dynamicfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSubmit.setOnClickListener {
            val input = etName.text.toString()
            //Add the FragmentB to your container
            addFragment(input)
        }

    }

    //Adds the Fragment to your container FrameLayout
    private fun addFragment(input: String) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.container, FragmentB(input))
            ?.commit()
    }


}