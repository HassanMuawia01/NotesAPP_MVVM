package com.example.noteapp_mvvm.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.noteapp_mvvm.Model.Notes
import com.example.noteapp_mvvm.R
import com.example.noteapp_mvvm.ViewModel.NotesViewModel
import com.example.noteapp_mvvm.databinding.FragmentCreateBinding
import java.util.Date

class CreateFragment : Fragment() {
    var priority:String="1"
    val viewModel:NotesViewModel by viewModels()
    lateinit var binding:FragmentCreateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCreateBinding.inflate(layoutInflater, container, false)
        binding.pGreen.setImageResource(R.drawable.baseline_done_24)
        binding.pGreen.setOnClickListener{
            priority="1"
            binding.pGreen.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.pYellow.setOnClickListener{
            priority="2"
            binding.pYellow.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }
        binding.pRed.setOnClickListener{
            priority="3"
            binding.pRed.setImageResource(R.drawable.baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }
        return binding.root
    }

    private fun createNotes(it: View?) {
     val title=binding.edittitle.text.toString()
     val subtitle=binding.editSubtitle.text.toString()
     val notes=binding.editNotes.text.toString()
         //date set
        val d=Date()
        val notesDate:CharSequence=DateFormat.format("MMMM, d, yyyy",d.time)

        //view model mein data create karny k liye
        val data=Notes(
            null,
            title=title,
            subtitle=subtitle,
            notes=notes,
            date=notesDate.toString(),
            priority
        )
        viewModel.addNotes(data)
        Toast.makeText(requireContext(),"Notes Created Successfully",Toast.LENGTH_LONG).show()
        Navigation.findNavController(it!!).navigate(R.id.action_createFragment_to_homeFragment)


    }

}