package com.example.noteapp_mvvm.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.noteapp_mvvm.NotesAdapter
import com.example.noteapp_mvvm.R
import com.example.noteapp_mvvm.ViewModel.NotesViewModel
import com.example.noteapp_mvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment()  {
    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getAllNotes().observe(viewLifecycleOwner, { notesList ->
            binding.recAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.recAllNotes.adapter = NotesAdapter(requireContext(), notesList)
        })

        binding.filterHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner, { notesList ->
                binding.recAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.recAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            })
        }
        binding.filterMedium.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner, { notesList ->
                binding.recAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.recAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            })
        }
        binding.filterLow.setOnClickListener {

            viewModel.getLowNotes().observe(viewLifecycleOwner, { notesList ->
                binding.recAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.recAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            })
        }
        binding.allNotes.setOnClickListener {

            viewModel.getAllNotes().observe(viewLifecycleOwner, { notesList ->
                binding.recAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.recAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            })
        }

        binding.btnaddNote.setOnClickListener {
            //go home to create fragment
             Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createFragment)
        }

        return binding.root
    }



}