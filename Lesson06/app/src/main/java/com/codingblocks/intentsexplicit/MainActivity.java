package com.codingblocks.intentsexplicit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNew(View view) {

//        //Implicit Intent
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:9968195588"));
//        startActivity(intent);
//
//        //Explicit Intent
//        Intent intent = new Intent(this,NewActivity.class);
//        startActivity(intent);

        //Can you use Implicit Intent to start NewActivity?
        Intent i = new Intent();
        i.setAction("skjdfskfghdfhj");
        startActivity(i);
    }
}
