package com.example.justdo.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.justdo.Model.Notes
import com.example.justdo.R
import com.example.justdo.databinding.FragmentEditBinding
import com.example.justdo.databinding.FragmentHomeBinding
import com.example.justdo.viewModel.NotesViewModel
import java.util.*

class EditFragment : Fragment() {

    lateinit var binding: FragmentEditBinding
    var priority:String = "1"
    val viewModel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentEditBinding.inflate(inflater,container,false)

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
        val edttitle=binding.edittile.text.toString()
        val edtsubTitle=binding.editsubtitle.text.toString()
        val edtnotes=binding.notes.text.toString()

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
        viewModel.updateNotes(data)

        Toast.makeText(requireContext(),"Data Updated",Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editFragment_to_homeFragment2)

    }

}