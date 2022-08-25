package com.jtarnoff.midtronicssample.ui.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.jtarnoff.midtronicssample.databinding.FragmentCountriesBinding
import com.jtarnoff.midtronicssample.databinding.FragmentCountryBinding
import com.jtarnoff.midtronicssample.repository.CountryRepository

class CountryFragment : Fragment() {
    private var _binding: FragmentCountryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // load country name from bundle
        val countryName = arguments?.getString("countryName")

        val countryViewModel: CountryViewModel by viewModels {
            CountryViewModelFactory(CountryRepository(activity!!), countryName!!)
        }

        _binding = FragmentCountryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // progress bar
        val progressBar: ProgressBar = binding.progressBar
        countryViewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
           if (it) {
               progressBar.visibility = View.VISIBLE
           } else {
               progressBar.visibility = View.INVISIBLE
           }
        })

        // Country Name
        val countryNameTextView: TextView = binding.textCountryName
        countryViewModel.countryName.observe(viewLifecycleOwner, Observer<String> {
            countryNameTextView.text = it
        })

        // Capital Name
        val capitalTextView: TextView = binding.textCapital
        countryViewModel.capital.observe(viewLifecycleOwner, Observer<String> {
            capitalTextView.text = it
        })

        // Population
        val populationTextView: TextView = binding.textPopulation
        countryViewModel.population.observe(viewLifecycleOwner, Observer<String> {
            populationTextView.text = it
        })

        // Area
        val areaTextView: TextView = binding.textArea
        countryViewModel.area.observe(viewLifecycleOwner, Observer<String> {
            areaTextView.text = it
        })

        // Region
        val regionTextView: TextView = binding.textRegion
        countryViewModel.region.observe(viewLifecycleOwner, Observer<String> {
            regionTextView.text = it
        })

        // Subregion
        val subregionTextView: TextView = binding.textSubregion
        countryViewModel.subregion.observe(viewLifecycleOwner, Observer<String> {
            subregionTextView.text = it
        })

        return root
    }
}