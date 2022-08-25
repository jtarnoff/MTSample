package com.jtarnoff.midtronicssample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jtarnoff.midtronicssample.R
import com.jtarnoff.midtronicssample.model.Job

class JobAdapter(private val mList: List<Job>) : RecyclerView.Adapter<JobAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_job, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val job = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textName.text = job.companyName
        holder.textYears.text = job.years
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textName: TextView = itemView.findViewById(R.id.text_job_name)
        val textYears: TextView = itemView.findViewById(R.id.text_job_years)
    }
}