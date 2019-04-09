package com.codingblocks.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> notesList = new ArrayList<>();
    EditText etTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btnAdd);

        etTitle = findViewById(R.id.etNote);

        ListView lv = findViewById(R.id.lvNotes);
        final NoteAdapter noteAdapter = new NoteAdapter(notesList, this);

        lv.setAdapter(noteAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String time = "" + System.currentTimeMillis();
                notesList.add(new Note(title, time));
                noteAdapter.notifyDataSetChanged();
            }
        });
    }

//    class ViewOnclickImpl implements View.OnClickListener {
//
//        EditText etTitle = 0x234324; //Points to the same memory address as the MainActivity's etTitle
//
//        @Override
//        public void onClick(View v) {
//            String title = etTitle.getText().toString();
//            String time = "" + System.currentTimeMillis();
//            notesList.add(new Note(title, time));
//        }
//    }

}
