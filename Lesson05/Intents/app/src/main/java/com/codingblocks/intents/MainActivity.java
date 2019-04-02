package com.codingblocks.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newActivity(View view) {
        //What if I want to start the SecondActivity on clicking this button?

        Intent startIntent = new Intent(getBaseContext(),
                SecondActivity.class);

        EditText input = findViewById(R.id.etName);
        String inputString = input.getText().toString();

        startIntent.putExtra("a", inputString);

//        getBaseContext().getColor(R.color.colorPrimary);
//        getBaseContext().getString(R.string.test);
//        getBaseContext().getDrawable(R.drawable.ic_launcher_background);

//        Log.e("TAG",
//                getPackageName() + "" +
//
//                        SecondActivity.class.getName());

        startActivity(startIntent);

    }
}
