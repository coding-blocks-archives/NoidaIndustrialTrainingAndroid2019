package com.codingblocks.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //getIntent() returns the Intent with which this Activity was started
        Intent intent = getIntent();

        String name = intent.getStringExtra("a");

        TextView tvName = findViewById(R.id.tvName);

        tvName.setText(name);

    }
}
