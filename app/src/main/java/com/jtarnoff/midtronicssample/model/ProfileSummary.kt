package com.jtarnoff.midtronicssample.model

data class ProfileSummary(
    val education: List<EducationItem>,
    val workExperience: List<Job>
)
