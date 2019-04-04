package com.codingblocks.listviewcustomadapter;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.activity_main);

        students.add(new Student("Vandit",
                "Goel",
                "MP",
                "12345"));
        students.add(new Student("Hari Om",
                "Sharma",
                "Punjab",
                "12345"));
        students.add(new Student("Divyansh",
                "Bharadwaj",
                "Punjab",
                "12345"));
        students.add(new Student("Priyanka",
                "Negi",
                "Haryana",
                "12345"));
        students.add(new Student("Sagar",
                "Sirohi",
                "Haryana",
                "12345"));
        students.add(new Student("Puneet",
                "Gulati",
                "Haryana",
                "12345"));
        students.add(new Student("Harshit",
                "Asija",
                "Haryana",
                "12345"));
        students.add(new Student("Rahul",
                "Rohilla",
                "Haryana",
                "12345"));
        students.add(new Student("Harshit",
                "Dwivedi",
                "Prayagraj",
                "12345"));

//        LayoutInflater li = (LayoutInflater)
//                getSystemService(LAYOUT_INFLATER_SERVICE);

        ListView listView = (ListView) viewById(R.id.lvStudents);
        StudentAdapter studentAdapter = new StudentAdapter(students, this);

        listView.setAdapter(studentAdapter);
    }

    public void setView(@LayoutRes int layout) {
        setContentView(layout);
    }

    public View viewById(@IdRes int id) {
        return findViewById(id);
    }

}
