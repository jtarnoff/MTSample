package com.jtarnoff.midtronicssample.ui.countries

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jtarnoff.midtronicssample.R
import com.jtarnoff.midtronicssample.adapter.CountryAdapter
import com.jtarnoff.midtronicssample.adapter.EducationItemAdapter
import com.jtarnoff.midtronicssample.databinding.FragmentCountriesBinding
import com.jtarnoff.midtronicssample.model.EducationItem
import com.jtarnoff.midtronicssample.repository.CountriesRepository
import com.jtarnoff.midtronicssample.ui.countries.CountriesViewModel
import com.jtarnoff.midtronicssample.utils.ClickListener

class CountriesFragment : Fragment() {

    private var _binding: FragmentCountriesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val countriesViewModel =
//            ViewModelProvider(this).get(CountriesViewModel::class.java)

        val countriesViewModel: CountriesViewModel by viewModels {
            CountriesViewModelFactory(CountriesRepository(activity!!))
        }

        _binding = FragmentCountriesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val titleTextView: TextView = binding.textCountriesTitle
        countriesViewModel.title.observe(viewLifecycleOwner, Observer<String> {
            titleTextView.text = it
        })

        val countriesRecyclerview: RecyclerView = binding.recyclerViewCountries
        countriesRecyclerview.layoutManager = LinearLayoutManager(activity)
        countriesViewModel.countries.observe(viewLifecycleOwner, Observer<List<String>> {
            val clickListener = ClickListener { id -> countriesViewModel.onCountryClicked(id) } // click. This function from ViewModel will be executed when You click on item in recycler View
            val countryAdapter = CountryAdapter(it, clickListener)
            countriesRecyclerview.adapter = countryAdapter
        })

        var selectedCountry: String = ""
        countriesViewModel.selectedCountry.observe(viewLifecycleOwner, Observer<String> {
            Log.d("JT", "Country card clicked")
            selectedCountry = it
        })

        countriesViewModel.onCountryClicked.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it) {
                countriesViewModel.navigateToCountryHandled()
                val bundle = bundleOf("countryName" to selectedCountry)
                view!!.findNavController().navigate(R.id.action_countries_to_country, bundle)
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}