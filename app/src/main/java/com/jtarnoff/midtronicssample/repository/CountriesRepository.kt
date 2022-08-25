package com.jtarnoff.midtronicssample.repository

import android.content.Context
import com.jtarnoff.midtronicssample.R


class CountriesRepository(private val context: Context) {
    fun getCountries() : List<String> {
        val res = context.resources
        val countries = res.getStringArray(R.array.countries_array)
        return countries.toList()
    }
}