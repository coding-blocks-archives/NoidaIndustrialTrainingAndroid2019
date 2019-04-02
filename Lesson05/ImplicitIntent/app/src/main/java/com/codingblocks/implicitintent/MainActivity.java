package com.codingblocks.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBrowser(View view) {

        EditText etInput = findViewById(R.id.etInput);

        //Search why toString() is required in EditText and not in TextView
        String input = etInput.getText().toString();

        //Convert the input String to a URI, and if it is an Invalid URI, throw and exception
        Uri inputUri = Uri.parse(input);

        Intent intent = new Intent();

        //This action defines my Intent, or what I want to do!
        //This is must for every intent,
        //an intent created without an action will fail
        intent.setAction(Intent.ACTION_VIEW);

        //The action defined above is performed on the data provided here (option)
        intent.setData(inputUri);

        startActivity(intent);

    }
}
