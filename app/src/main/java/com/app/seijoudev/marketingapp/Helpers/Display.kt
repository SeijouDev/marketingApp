package com.app.seijoudev.marketingapp.Helpers

import android.content.Context
import android.util.Log
import android.widget.Toast

class Display {

    companion object {

        fun log (s: String) {
            Log.e("MarketingAppLogs" , s)
        }

        fun toast (c: Context, s: String) {
            Toast.makeText(c, s, Toast.LENGTH_SHORT).show()
        }
    }
}