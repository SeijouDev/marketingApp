package com.app.seijoudev.marketingapp.Views.Fragments

import android.app.Fragment
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.app.seijoudev.marketingapp.R
import com.app.seijoudev.marketingapp.Views.Activities.MainActivity

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var mView = inflater.inflate(R.layout.fragment_profile, container, false)

        mView.findViewById<TextView>(R.id.link_signup).setOnClickListener(View.OnClickListener {
            (activity as MainActivity).goToSignUp()
        })

        return mView
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
