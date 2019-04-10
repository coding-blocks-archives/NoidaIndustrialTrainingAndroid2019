package com.codingblocks.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button button;

    public String getContentFromUrl(String inputUrl) {
        String output = null;
        //Getting things from the URL
        return output;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnStart);
        String result = getContentFromUrl("www.google.com");

        if (result != null) {
            Character c = result.charAt(3);
        }

        if (savedInstanceState != null) {
            String key = savedInstanceState.getString("sdfdfs");
        } else {
            Toast.makeText(this, "Bundle is null", Toast.LENGTH_SHORT).show();
        }
//        Toast toast = new Toast(this);
//        toast.setGravity();
//        toast.setMargin();
//        toast.setView();
        final TextView tvStatus = findViewById(R.id.tvStatus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Thread.sleep(10000);

                tvStatus.setText("Counting Started");

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (long i = 0; i < 1000000L; i++) {
                        }

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvStatus.setText("Counting done!");

                                Toast.makeText(getBaseContext(),
                                        "Counting Done",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                t.start();
            }
        });

    }
}
