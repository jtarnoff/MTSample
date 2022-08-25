package com.jtarnoff.midtronicssample.ui.countries

import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.jtarnoff.midtronicssample.R
import com.jtarnoff.midtronicssample.repository.CountriesRepository

class CountriesViewModel(private val countriesRepository: CountriesRepository) : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = "Choose a country"
    }
    val title: LiveData<String> = _title

    val countries: LiveData<List<String>> = liveData {
        val data = countriesRepository.getCountries()
        emit(data)
    }

    private val _onCountryClicked = MutableLiveData<Boolean>()
    val onCountryClicked: LiveData<Boolean> = _onCountryClicked

    private val _selectedCountry = MutableLiveData<String>()
    val selectedCountry: LiveData<String> = _selectedCountry

    fun onCountryClicked(name: String) {
        _selectedCountry.value = name
        _onCountryClicked.value = true
        Log.d("JT", "onCountryClicked")
    }

    fun navigateToCountryHandled() {
        _onCountryClicked.value = false
    }
}