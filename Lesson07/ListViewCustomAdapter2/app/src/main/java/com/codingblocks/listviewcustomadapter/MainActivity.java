package com.codingblocks.listviewcustomadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lvPeople);
        PersonAdapter personAdapter = new PersonAdapter(Person.getRandomPeople(),this);

        listView.setAdapter(personAdapter);

//        LayoutInflater.from(this);

//
//        getBaseContext().getSystemService()
//        getSystemService()
//
//        TextView textView;
//
//        textView.findViewById();
//
//        findViewById();

    }

}
