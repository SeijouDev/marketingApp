package com.app.seijoudev.marketingapp.Helpers

import org.json.JSONObject
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL


class HttpHelper {

    fun executePost(urlr: String, data: JSONObject): String? {

        try {

            val url = URL(urlr)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.setDoOutput(true)
            urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0")

            // is output buffer writter
            urlConnection.setRequestMethod("POST")
            urlConnection.setRequestProperty("Content-Type", "application/json")
            urlConnection.setRequestProperty("Accept", "application/json")

            //set headers and method
            val writer = BufferedWriter(OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"))
            writer.write(data.toString())

            // json data
            writer.close()
            val inputStream = urlConnection.getInputStream()

            //input stream
            val buffer = StringBuffer()

            if (inputStream == null) {
                return null
            }

            val reader = BufferedReader(InputStreamReader(inputStream))

            var inputLine: String


            do {

                inputLine = reader.readLine()

                if(inputLine != null) {
                    buffer.append("$inputLine\n")
                }
            }
            while (inputLine != null)

            if (buffer.length == 0) {
                // Stream was empty. No point in parsing.
                return null
            }

            val JsonResponse = buffer.toString()

            //response data
            Display.log(JsonResponse)

            return JsonResponse

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun executeGet(urlr: String): String? {

        try {

            val url = URL(urlr)

            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("USER-AGENT", "Mozilla/5.0")
            connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5")

            val responseCode = connection.responseCode

            val output = StringBuilder("Request URL $url")
            output.append(System.getProperty("line.separator") + "Response Code " + responseCode)
            output.append(System.getProperty("line.separator") + "Type " + "GET")
            val br = BufferedReader(InputStreamReader(connection.inputStream))
            var line = ""
            val responseOutput = StringBuilder()
            println("output===============$br")
            do {

                line = br.readLine()

                if(line != null) {
                    responseOutput.append("$line\n")
                }
            }
            while (line != null)

            br.close()

            return responseOutput.toString()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

}