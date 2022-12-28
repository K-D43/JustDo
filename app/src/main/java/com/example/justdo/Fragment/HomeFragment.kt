package com.example.justdo.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.justdo.Adapter.NotesAdapter
import com.example.justdo.R
import com.example.justdo.databinding.FragmentHomeBinding
import com.example.justdo.viewModel.NotesViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel:NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val binding=FragmentHomeBinding.inflate(inflater,container,false)

        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->

            binding.RView.layoutManager=GridLayoutManager(requireContext(),2)
            binding.RView.adapter=NotesAdapter(requireContext(),notesList)

        }

        binding.filter.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
                binding.RView.layoutManager=GridLayoutManager(requireContext(),2)
                binding.RView.adapter=NotesAdapter(requireContext(),notesList)
            }
        }
        binding.filterHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner) { notesList ->
                binding.RView.layoutManager=GridLayoutManager(requireContext(),2)
                binding.RView.adapter=NotesAdapter(requireContext(),notesList)
            }
        }
        binding.filterMedium.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner) { notesList ->
                binding.RView.layoutManager=GridLayoutManager(requireContext(),2)
                binding.RView.adapter=NotesAdapter(requireContext(),notesList)
            }
        }
        binding.filterLow.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner) { notesList ->
                binding.RView.layoutManager=GridLayoutManager(requireContext(),2)
                binding.RView.adapter=NotesAdapter(requireContext(),notesList)
            }
        }



        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment2_to_createFragment)
        }
        return binding.root
    }
}