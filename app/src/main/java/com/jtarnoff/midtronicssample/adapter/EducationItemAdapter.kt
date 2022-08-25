package com.jtarnoff.midtronicssample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jtarnoff.midtronicssample.R
import com.jtarnoff.midtronicssample.model.EducationItem

class EducationItemAdapter(private val mList: List<EducationItem>) : RecyclerView.Adapter<EducationItemAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_education_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val educationItem = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textName.text = educationItem.name
        holder.textYears.text = educationItem.years
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    fun submitList(items: List<EducationItem>) {

    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textName: TextView = itemView.findViewById(R.id.text_education_item_name)
        val textYears: TextView = itemView.findViewById(R.id.text_education_item_years)
    }
}