package com.codingblocks.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students.add("Vandit");
        students.add("Hari Om");
        students.add("Divyansh");
        students.add("Priyanka");
        students.add("Sagar");
        students.add("Puneet");
        students.add("Harshit");
        students.add("Rahul");
        students.add("Jyoti");
        students.add("Shivam");
        students.add("Anmol");
        students.add("Raevat");
        students.add("Piyush");
        students.add("Shivam");
        students.add("Sashrika");
        students.add("Akshay");
        students.add("Harshit");

        ArrayAdapter studentAdapter = new ArrayAdapter<>(
                this,
                R.layout.item_row,
                R.id.tvName,
                students
        );

        ListView listView = findViewById(R.id.listView);

        listView.setAdapter(studentAdapter);
    }
}
