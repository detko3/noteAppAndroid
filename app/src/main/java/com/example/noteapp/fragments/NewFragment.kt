package com.example.noteapp.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.noteapp.MainActivity
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNewBinding
import com.example.noteapp.entities.Note
import com.example.noteapp.viewModels.NoteViewModel
import com.google.android.material.snackbar.Snackbar

class NewFragment : Fragment(R.layout.fragment_new) {
    lateinit var binding: FragmentNewBinding
    lateinit var noteViewModel: NoteViewModel
    lateinit var myView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myView = view
        noteViewModel = (activity as MainActivity).noteViewModel
    }

    fun onSave(view: View) {
        val title = binding.noteTit.text.toString().trim()
        val desc = binding.noteDesc.text.toString().trim()

        if (title.isNotEmpty()) {
            val note = Note(0, title, desc)
            noteViewModel.addNote(note)
            Snackbar.make(view, "Note saved successfully", Snackbar.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_newFragment_to_homeFragment)
        } else {
            Toast.makeText(activity, "Title is empty", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.new_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_save -> onSave(myView)
        }
        return super.onOptionsItemSelected(item)
    }
}