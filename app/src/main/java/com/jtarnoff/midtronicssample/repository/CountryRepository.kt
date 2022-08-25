package com.jtarnoff.midtronicssample.repository

import android.content.Context
import android.util.Log
import com.beust.klaxon.Klaxon
import com.jtarnoff.midtronicssample.model.Country
import com.jtarnoff.midtronicssample.utils.Utils
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

class CountryRepository(private val context: Context) {
    // set up OkHttp client object
    var client: OkHttpClient = OkHttpClient()

    fun fetchCountry(name: String) : Country? {
        var country: Country? = null
        val sUrl : String = "https://restcountries.com/v3.1/name/$name"

        val jsonString = getRequest(sUrl)
        Log.d("JT","jsonString: $jsonString")

        if (jsonString != null) {
            try {
                country = Klaxon().parse<Country>(trim(jsonString))
            } catch (err: Error) {
                Log.d("JT", "Error when parsing JSON: ${err.localizedMessage}")
            }
        } else {
            Log.d("JT", "Error: Get request returned no response")
        }
        return country
    }

    private fun getRequest(sUrl: String) : String? {
        var result: String? = null

        try {
            // Create URL
            val url = URL(sUrl)

            // Build request
            val request = Request.Builder().url(url).build()

            // Execute request
            val response = client.newCall(request).execute()
            result = response.body?.string()
        }
        catch(err:Error) {
            print("Error when executing get request: "+err.localizedMessage)
        }
        return result
    }

    // remove list brackets from response
    private fun trim(input: String) : String {
        var output = input.drop(1)
        output = output.dropLast(1)
        return output
    }
}