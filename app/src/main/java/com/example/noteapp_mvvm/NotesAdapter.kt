package com.example.noteapp_mvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp_mvvm.Model.Notes
import com.example.noteapp_mvvm.databinding.ItemNotesBinding
import com.example.noteapp_mvvm.ui.Fragments.HomeFragmentDirections


class NotesAdapter(val requireContext: Context, val dataArraryList: List<Notes>):RecyclerView.Adapter<NotesAdapter.NotesViewModel>() {
    class NotesViewModel(val binding:ItemNotesBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewModel {
        val binding=ItemNotesBinding.inflate(LayoutInflater.from(requireContext),parent,false)
        return NotesViewModel(binding)
    }

    override fun onBindViewHolder(holder: NotesViewModel, position: Int) {
       val data=dataArraryList[position]
        holder.binding.notesTitle.text=data.title
        holder.binding.notesSubtitle.text=data.subtitle
        holder.binding.notesDate.text=data.date

        when(data.priority){
            "1"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_dot)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)
            }
        }
        holder.binding.root.setOnClickListener {
            val action=HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
       return dataArraryList.size
    }


}


