package com.codingblocks.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private ArrayList<Note> notes;
    private Context context;

    public NoteAdapter(ArrayList<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    //Only called when there are no more views left to recycler
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemView) {
        LayoutInflater li = LayoutInflater.from(context);
        View inflatedView = li.inflate(R.layout.item_note,viewGroup,false);
        return new NoteHolder(inflatedView);
    }

    //Called every time for all the positions
    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int position) {
        //Get the current note
        Note currentNote = notes.get(position);
        noteHolder.tvTime.setText(currentNote.getTime());
        noteHolder.tvTitle.setText(currentNote.getTitle());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvTime;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvNote);
            tvTime = itemView.findViewById(R.id.tvNoteTime);
        }
    }

}