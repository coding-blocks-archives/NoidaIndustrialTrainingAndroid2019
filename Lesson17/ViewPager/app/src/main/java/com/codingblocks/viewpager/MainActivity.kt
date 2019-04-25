package com.codingblocks.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    FragmentA()
                }
                1 -> {
                    FragmentB()
                }
                2 -> {
                    FragmentC()
                }
                3 -> {
                    FragmentD()
                }
                4 -> {
                    FragmentE()
                }
                else -> {
                    FragmentA()
                }
            }
        }

        override fun getCount() = 5

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Sports"
                1 -> "Tech"
                2 -> "Hollywood"
                3 -> "Business"
                4 -> "Misc."
                else -> "Others"
            }
        }
    }
}
