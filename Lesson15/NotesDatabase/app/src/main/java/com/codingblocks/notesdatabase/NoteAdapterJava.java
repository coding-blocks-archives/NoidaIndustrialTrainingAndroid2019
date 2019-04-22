package com.codingblocks.notesdatabase;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapterJava extends RecyclerView.Adapter<NoteAdapterJava.NoteHolderJava> {
    @NonNull
    @Override
    public NoteHolderJava onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolderJava holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Position
            }
        });
    }

    public class NoteHolderJava extends RecyclerView.ViewHolder {
        public NoteHolderJava(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    getAdapterPosition() // gives the current position

                }
            });

        }
    }
}
