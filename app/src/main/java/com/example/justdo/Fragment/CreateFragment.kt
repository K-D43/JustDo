package com.example.justdo.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.justdo.Model.Notes
import com.example.justdo.R
import com.example.justdo.databinding.FragmentCreateBinding
import com.example.justdo.viewModel.NotesViewModel
import java.text.DateFormat
import java.util.*


class CreateFragment : Fragment() {

    lateinit var binding: FragmentCreateBinding
    var priority:String = "1"
    val viewModel:NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCreateBinding.inflate(inflater,container,false)
        binding.pgreen.setImageResource(R.drawable.ic_done)

        binding.btnSaveNotes.setOnClickListener{
            createNotes(it)
        }

        binding.pgreen.setOnClickListener{
            priority="1"
            binding.pgreen.setImageResource(R.drawable.ic_done)
            binding.pred.setImageResource(0)
            binding.pyellow.setImageResource(0)

        }
        binding.pyellow.setOnClickListener{
            priority="2"
            binding.pyellow.setImageResource(R.drawable.ic_done)
            binding.pgreen.setImageResource(0)
            binding.pred.setImageResource(0)

        }
        binding.pred.setOnClickListener{
            priority="3"
            binding.pred.setImageResource(R.drawable.ic_done)
            binding.pgreen.setImageResource(0)
            binding.pyellow.setImageResource(0)
        }


        return binding.root
    }

    private fun createNotes(it: View?) {
        val edttitle=binding.editTitle.text.toString()
        val edtsubTitle=binding.editsubTitle.text.toString()
        val edtnotes=binding.writenotes.text.toString()

        val d= Date()
        val notesDate:CharSequence=android.text.format.DateFormat.format("MMMM d, yyyy ",d.time)
//        Log.e("tag","createNotes $s")
        val data= Notes(null,
            title = edttitle,
            subTitle = edtsubTitle,
            notes = edtnotes,
            date = notesDate.toString(),
            priority
        )
        viewModel.addNotes(data)

        Toast.makeText(requireContext(),"Data submitted",Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_createFragment_to_homeFragment2)

    }
}