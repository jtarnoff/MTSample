package com.jtarnoff.midtronicssample.ui.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jtarnoff.midtronicssample.repository.CountriesRepository


class CountriesViewModelFactory(private val countriesRepository: CountriesRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountriesViewModel(countriesRepository) as T
    }
}