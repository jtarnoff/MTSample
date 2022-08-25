package com.jtarnoff.midtronicssample.ui.country

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jtarnoff.midtronicssample.model.Country
import com.jtarnoff.midtronicssample.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel(
    private val countryRepository: CountryRepository,
    private val name: String
) : ViewModel() {

    var country: Country? = null

    init {
        fetchCountry(name)
    }

    private fun fetchCountry(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                // this tells view to show progress bar
                _isLoading.value = true
            }

            // load country data from repository
            country = countryRepository.fetchCountry(name)
            Log.d("JT", country.toString())

            withContext(Dispatchers.Main) {
                // Update view model
                _countryName.value = name
                _capital.value = country?.capital?.get(0)
                _population.value = country?.population.toString()
                _area.value = country?.area?.toInt().toString()
                _region.value = country?.region
                _subregion.value = country?.subregion
                _isLoading.value = false
            }
        }
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _countryName = MutableLiveData<String>()
    val countryName: LiveData<String> = _countryName

    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital

    private val _population = MutableLiveData<String>()
    val population: LiveData<String> = _population

    private val _area = MutableLiveData<String>()
    val area: LiveData<String> = _area

    private val _region = MutableLiveData<String>()
    val region: LiveData<String> = _region

    private val _subregion = MutableLiveData<String>()
    val subregion: LiveData<String> = _subregion
}