package com.jtarnoff.midtronicssample.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jtarnoff.midtronicssample.adapter.EducationItemAdapter
import com.jtarnoff.midtronicssample.adapter.JobAdapter
import com.jtarnoff.midtronicssample.model.EducationItem
import com.jtarnoff.midtronicssample.model.Job
import com.jtarnoff.midtronicssample.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var educationItemAdapter: EducationItemAdapter
    private lateinit var jobAdapter: JobAdapter

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val profileImageView: AppCompatImageView = binding.imageProfile
        profileViewModel.imageResourceId.observe(viewLifecycleOwner) {
            profileImageView.setImageResource(it)
        }

        val profileNameTextView: TextView = binding.textProfileName
        profileViewModel.name.observe(viewLifecycleOwner) {
            profileNameTextView.text = it
        }

        val educationRecyclerview: RecyclerView = binding.recyclerViewEducationItems
        educationRecyclerview.layoutManager = LinearLayoutManager(activity)
        profileViewModel.getEducationItems().observe(viewLifecycleOwner, Observer<List<EducationItem>> {
            educationItemAdapter = EducationItemAdapter(it)
            educationRecyclerview.adapter = educationItemAdapter
        })

        val jobRecyclerview: RecyclerView = binding.recyclerViewJobs
        jobRecyclerview.layoutManager = LinearLayoutManager(activity)
        profileViewModel.getJobs().observe(this, Observer<List<Job>> {
            jobAdapter = JobAdapter(it)
            jobRecyclerview.adapter = jobAdapter
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}