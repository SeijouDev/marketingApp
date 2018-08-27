package com.app.seijoudev.marketingapp.Helpers

import android.widget.DatePicker
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import java.util.Calendar


class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private var callback: OnTaskCompleted? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(activity, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {

        this.callback!!.onTaskCompleted("$year-${fixNumber(month+1)}-${fixNumber(day)}")
    }

    fun setCallback(callback: OnTaskCompleted) {
        this.callback = callback
    }

    private fun fixNumber (number: Int) : String {
        return if (number < 10) "0$number" else "$number"
    }
}