package com.jtarnoff.midtronicssample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jtarnoff.midtronicssample.R
import com.jtarnoff.midtronicssample.databinding.CardCountryBinding
import com.jtarnoff.midtronicssample.utils.ClickListener

class CountryAdapter(
    private val mList: List<String>,
    private val clickListener: ClickListener
    ) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        // inflates the card_view_design view
//        // that is used to hold list item
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.card_country, parent, false)
//
//        val binding: CardCountryBinding =
//            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.card_country, parent, false)

        return ViewHolder.from(
            parent
        )
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = mList[position]
        holder.bind(country, clickListener)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder private constructor(private val binding: CardCountryBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
        companion object
        {
            fun from(parent: ViewGroup): ViewHolder
            {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CardCountryBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }

        fun bind(
            country: String,
            clickListener: ClickListener
        )
        {
            binding.country = country
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }
}



