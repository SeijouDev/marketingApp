package com.app.seijoudev.marketingapp.Views.Activities

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener
import android.support.v7.app.AppCompatActivity
import com.app.seijoudev.marketingapp.R
import com.app.seijoudev.marketingapp.Views.Fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        lateinit var nextFragment: Fragment

        when (item.itemId) {
            R.id.navigation_home -> nextFragment = HomeFragment()
            R.id.navigation_search -> nextFragment = SearchFragment()
            R.id.navigation_notifications -> nextFragment = NotificationsFragment()
            R.id.navigation_profile ->  nextFragment = ProfileFragment()
        }

        changeFragment(nextFragment)

        true

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        changeFragment(ProfileFragment())

    }

    private fun changeFragment(newFragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, newFragment)
        fragmentTransaction.commit()
    }

    fun goToSignUp(){
        changeFragment(SignupFragment())
    }
}
