package com.codingblocks.counter;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //TAG should be different for different java classes
    public String TAG = getClass().getSimpleName();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increment(View view) {
        count++;
        Log.e(TAG, "" + count);
        //Set the count to the text
        TextView counterText = findViewById(R.id.countTextView);
        counterText.setText("" + count);

    }
}
