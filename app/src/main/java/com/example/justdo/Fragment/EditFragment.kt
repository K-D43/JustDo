package com.example.justdo.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.justdo.R
import com.example.justdo.databinding.FragmentEditBinding
import com.example.justdo.databinding.FragmentHomeBinding

class EditFragment : Fragment() {

    lateinit var binding: FragmentEditBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentEditBinding.inflate(inflater,container,false)

        return binding.root
    }

}