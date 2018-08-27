package com.app.seijoudev.marketingapp.Objects

import org.json.JSONException
import org.json.JSONObject

class User {

    var id: Int?
    var name: String
    var birthdate: String
    var email: String
    var sex: Int
    var address: String? = null

    constructor(id: Int? ,name: String, birthdate: String, email: String, sex: Int, address: String?) {
        this.id = id
        this.name = name
        this.birthdate = birthdate
        this.email = email
        this.sex = sex
        this.address = address
    }

    companion object {

        fun getUserFromJson(json: String) : User? {

            var u : User? = null

            try {

                val jsonObj = JSONObject(json)


            }
            catch (e: JSONException) {
                e.printStackTrace()
            }

            return u
        }


    }
}