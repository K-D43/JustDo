package com.example.justdo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.justdo.Model.Notes
import com.example.justdo.R
import com.example.justdo.databinding.ItemNotesBinding
import com.example.justdo.viewModel.NotesViewModel

class NotesAdapter(val context:Context,val notesList: List<Notes>) :RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {


    class NotesViewHolder(val binding:ItemNotesBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data=notesList[position]
        holder.binding.titleOfNotes.text=data.title
        holder.binding.contentOfNotes.text=data.notes
        holder.binding.dateOfNotes.text=data.date

        when(data.priority){
            "1"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_circle)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_circle)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_circle)
            }
        }
        holder.binding.root.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}