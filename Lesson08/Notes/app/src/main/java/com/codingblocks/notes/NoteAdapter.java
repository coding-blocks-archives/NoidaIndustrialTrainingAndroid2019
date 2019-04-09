package com.codingblocks.notes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NoteAdapter extends BaseAdapter {

    private ArrayList<Note> notes;
    private Context ctx;
    private LayoutInflater li;

    public NoteAdapter(ArrayList<Note> notes, Context ctx) {
        this.notes = notes;
        this.ctx = ctx;
        li = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //This class stores the views that have been found already
    class ViewHolder {
        private TextView tvTitle, tvTime;

        public ViewHolder(View parentView) {
            tvTime = parentView.findViewById(R.id.tvNoteTime);
            tvTitle = parentView.findViewById(R.id.tvNote);
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Note currentNote = notes.get(position);
        View inflatedView;

        if (convertView == null) {
            inflatedView = li.inflate(R.layout.item_note, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflatedView);
            inflatedView.setTag(viewHolder);
        } else {
            inflatedView = convertView;
        }

        ViewHolder viewHolder = (ViewHolder) inflatedView.getTag();
        viewHolder.tvTime.setText(currentNote.getTime());
        viewHolder.tvTitle.setText(currentNote.getTitle());

//        tvTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//
//        tvTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        inflatedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "onClick: " + position);
                notes.remove(position);
                notifyDataSetChanged();
            }
        });

//        TextView tvTitle = new TextView(ctx);
//        tvTitle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
//        tvTitle.setTextSize(32f);
//        tvTitle.setText(currentNote.getTitle());
//
//        TextView tvTime = new TextView(ctx);
//        tvTitle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
//        tvTitle.setTextSize(32f);
//        tvTitle.setText(currentNote.getTime());
//
//        LinearLayout ll = new LinearLayout(ctx);
//        ll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
//
//        ll.setOrientation(LinearLayout.VERTICAL);
//
//        ll.addView(tvTitle);
//        ll.addView(tvTime);

        return inflatedView;
    }
}
