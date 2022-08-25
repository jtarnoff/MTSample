package com.jtarnoff.midtronicssample.ui.country

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jtarnoff.midtronicssample.repository.CountryRepository

class CountryViewModelFactory(
    private val countryRepository: CountryRepository,
    private val name: String
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryViewModel(countryRepository, name) as T
    }

}
