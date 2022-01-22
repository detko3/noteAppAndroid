package com.example.noteapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.NoteAdapterBinding
import com.example.noteapp.entities.Note

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: NoteAdapterBinding):  RecyclerView.ViewHolder(binding.root)

    private val differCallBack =
        object: DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.title == newItem.title &&
                        oldItem.description == newItem.description &&
                        oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }

        }

    val differ = AsyncListDiffer(this, differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(NoteAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = differ.currentList[position]

        holder.binding.noteTitle.text = note.title
        holder.binding.noteDescription.text = note.description

        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}