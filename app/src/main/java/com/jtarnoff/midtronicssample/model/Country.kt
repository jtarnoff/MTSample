package com.jtarnoff.midtronicssample.model

import com.beust.klaxon.Json

data class Country(
    val capital: Array<String>? = arrayOf(""),
    val population: Int? = 0,
    val area: Float? = 0.0f,
    val region: String = "",
    val subregion: String = ""
)
