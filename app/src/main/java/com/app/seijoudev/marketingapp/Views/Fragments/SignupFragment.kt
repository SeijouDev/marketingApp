package com.app.seijoudev.marketingapp.Views.Fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.app.seijoudev.marketingapp.R
import com.app.seijoudev.marketingapp.Helpers.DatePickerFragment
import com.app.seijoudev.marketingapp.Helpers.OnTaskCompleted
import com.app.seijoudev.marketingapp.Helpers.Display


class SignupFragment : Fragment() {

    lateinit var mView: View
    private var sexTemp: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_signup, container, false)

        configView()

        return mView
    }

    /*****************************************************************************/

    private fun configView () {
        configSpinner()
        configDatePicker()

        mView.findViewById<Button>(R.id.btn_signup).setOnClickListener{
            validateFields()
        }
    }

    private fun configSpinner () {
        val spinner = mView.findViewById(R.id.input_sex) as Spinner
        val adapter = ArrayAdapter.createFromResource(activity.applicationContext, R.array.sex_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setOnItemSelectedListener(spinnerListener);
    }

    private fun configDatePicker () {
        mView.findViewById<View>(R.id.input_date).setOnClickListener {
            val newFragment = DatePickerFragment()
            newFragment.setCallback(dateSelectedCallback)
            newFragment.show(fragmentManager, "datePicker")
        }
    }

    /*****************************************************************************/

    private fun validateFields () {
        val name = (mView.findViewById<EditText>(R.id.input_name)).text.toString()
        val birthdate = (mView.findViewById<TextView>(R.id.input_date)).text.toString()
        val address = (mView.findViewById<EditText>(R.id.input_address)).text.toString()
        val email = (mView.findViewById<EditText>(R.id.input_email)).text.toString()
        val pass1 = (mView.findViewById<EditText>(R.id.input_password)).text.toString()
        val pass2 = (mView.findViewById<EditText>(R.id.input_password2)).text.toString()
        val sex = sexTemp

        var msg: String? = null

        if(name.trim().length < 3) {
            msg = getString(R.string.valid_name_required)
        }
        else if (sex == 0){
            msg = getString(R.string.valid_sex_required)
        }
        else if (email.trim().length < 5) {
            msg = getString(R.string.valid_email_required)
        }
        else if (birthdate.trim().isEmpty()) {
            msg = getString(R.string.valid_birthdate_required)
        }
        else if(pass1.trim().isEmpty() || pass2.trim().isEmpty()) {
            msg = getString(R.string.valid_pass_required)
        }
        else if (pass1 != pass2) {
            msg = getString(R.string.password_dont_match)
        }

        if(msg != null) {
            Display.toast(activity.applicationContext, msg)
        }
        else {
            Display.log(name)
            Display.log(birthdate)
            Display.log(address)
            Display.log(email)
            Display.log(pass1)
            Display.log(pass2)
            Display.log("$sex")
        }

    }

    /*****************************************************************************/


    private val spinnerListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
            sexTemp = i
        }
        override fun onNothingSelected(adapterView: AdapterView<*>) {}
    }

    private val dateSelectedCallback = object : OnTaskCompleted {
        override fun onTaskCompleted(response: String) {
            (mView.findViewById(R.id.input_date) as TextView).text = response
        }
    }

}
