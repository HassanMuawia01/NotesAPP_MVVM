package com.example.noteapp_mvvm.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.noteapp_mvvm.Model.Notes
import com.example.noteapp_mvvm.R
import com.example.noteapp_mvvm.ViewModel.NotesViewModel
import com.example.noteapp_mvvm.databinding.FragmentEditNotesBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Date

class EditNotesFragment : Fragment() {
    val oldNotes by navArgs<EditNotesFragmentArgs>()
    var priority:String="1"
    val viewModel: NotesViewModel by viewModels()
 lateinit var binding: FragmentEditNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentEditNotesBinding.inflate(layoutInflater,container, false)

        binding.edittitle.setText(oldNotes.data.title)
        binding.editSubtitle.setText(oldNotes.data.subtitle)
        binding.editNotes.setText(oldNotes.data.notes)

        when(oldNotes.data.priority){
            "1"->{
                priority="1"
                binding.pGreen.setImageResource(R.drawable.baseline_done_24)
                binding.pRed.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
            "2"->{
                priority="2"
                binding.pYellow.setImageResource(R.drawable.baseline_done_24)
                binding.pRed.setImageResource(0)
                binding.pGreen.setImageResource(0)
            }
            "3"->{
                priority="3"
                binding.pRed.setImageResource(R.drawable.baseline_done_24)
                binding.pGreen.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
        }
        binding.pGreen.setOnClickListener {
            priority="1"
            binding.pGreen.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.pYellow.setOnClickListener {
            priority="2"
            binding.pYellow.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }
        binding.pRed.setOnClickListener {
            priority="3"
            binding.pRed.setImageResource(R.drawable.baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }
        binding.btnEditSaveNotes.setOnClickListener {
            updateNotes(it)
        }

        binding.deleteData.setOnClickListener {
            val bottomSheet:BottomSheetDialog= BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.dialog_delete)

            val buttonYes=bottomSheet.findViewById<TextView>(R.id.Yes)
            val buttonNo=bottomSheet.findViewById<TextView>(R.id.No)

            buttonYes?.setOnClickListener {
                viewModel.deleteNotes(oldNotes.data.id!!)
                bottomSheet.dismiss()
                //Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
            }
            buttonNo?.setOnClickListener {
                bottomSheet.dismiss()
            }

        }
        return binding.root

    }

    private fun updateNotes(it: View?) {
        val title=binding.edittitle.text.toString()
        val subtitle=binding.editSubtitle.text.toString()
        val notes=binding.editNotes.text.toString()
        //date set
        val d= Date()
        val notesDate:CharSequence= DateFormat.format("MMMM, d, yyyy",d.time)

        //view model mein data create karny k liye
        val data= Notes(
            oldNotes.data.id,
            title=title,
            subtitle=subtitle,
            notes=notes,
            date=notesDate.toString(),
            priority
        )
        viewModel.updateNotes(data)
        Toast.makeText(requireContext(),"Notes Created Successfully", Toast.LENGTH_LONG).show()
             Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)

    }


}