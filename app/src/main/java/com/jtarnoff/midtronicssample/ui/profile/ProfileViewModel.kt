package com.jtarnoff.midtronicssample.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jtarnoff.midtronicssample.R
import com.jtarnoff.midtronicssample.model.EducationItem
import com.jtarnoff.midtronicssample.model.Job

class ProfileViewModel : ViewModel() {

    // Profile Name
    private val _name = MutableLiveData<String>().apply {
        value = "Justin Tarnoff"
    }
    val name: LiveData<String> = _name

    // Profile image
    private val _imageResourceId = MutableLiveData<Int>().apply {
        value = R.drawable.profile
    }
    val imageResourceId: LiveData<Int> = _imageResourceId

    val educationItemsLiveData = MutableLiveData<List<EducationItem>>().apply {
        value = loadEducationItems()
    }

    fun getEducationItems(): LiveData<List<EducationItem>> {
        return educationItemsLiveData
    }

    private val jobsLiveData = MutableLiveData<List<Job>>().apply {
        value = loadJobs()
    }

    fun getJobs(): LiveData<List<Job>> {
        return jobsLiveData
    }

    private fun loadEducationItems() : List<EducationItem> {
        return listOf(
            EducationItem(
                "University of Illinois",
                "2002-2006"
            ),
            EducationItem(
                "School of Hard Knocks",
                "1984-2022"
            )
        )
    }

    private fun loadJobs() : List<Job> {
        val job1 = Job(
            "CVS/Caremark",
            "2006-2014",
            listOf(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
            )
        )

        val job2 = Job(
            "AMI Entertainment",
            "2014-2020",
            listOf(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
            )
        )

        val job3 = Job(
            "Whirlpool Corporation",
            "2020-2022",
            listOf(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"
            )
        )

        return listOf(job3, job2, job1)
    }

//    // load a default profile
//    private fun loadProfile(): Profile {
//        return Profile(
//            "Justin Tarnoff",
//            1,
//            ProfileSummary(
//                loadEducationItems(),
//                loadJobs()
//            )
//        )
//    }
}