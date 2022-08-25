package com.jtarnoff.midtronicssample.model

data class Profile(
    val name: String, // person's full name
    val imageResource: Int,
    val profileSummary: ProfileSummary
)
