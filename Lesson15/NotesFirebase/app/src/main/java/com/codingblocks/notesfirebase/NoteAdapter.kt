package com.codingblocks.notesdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.codingblocks.notesfirebase.Note
import com.codingblocks.notesfirebase.R
import kotlinx.android.synthetic.main.item_row.view.*

class NoteAdapter(private val notes: ArrayList<Note?>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        context = parent.context

        val inflatedView = LayoutInflater.from(context)
            .inflate(R.layout.item_row, parent, false)

        return NoteHolder(inflatedView)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = notes[position]

        with(holder.itemView) {
            tvTitle.text = currentNote?.title
            tvDesc.text = currentNote?.description
            tvDate.text = currentNote?.date
        }
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, notes[adapterPosition]?.title, Toast.LENGTH_SHORT).show()
            }
            //            itemView.setOnTouchListener { v, event : MotionEvent ->
//                when(event.action){
//                    MotionEvent.ACTION_UP -> {
//
//                    }
//
//                }
//            }
        }

    }
}