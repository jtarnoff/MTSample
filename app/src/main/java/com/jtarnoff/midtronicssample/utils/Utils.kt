package com.jtarnoff.midtronicssample.utils

import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

object Utils {
    var client: OkHttpClient = OkHttpClient();

    public fun getRequest(sUrl: String): String? {
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
}