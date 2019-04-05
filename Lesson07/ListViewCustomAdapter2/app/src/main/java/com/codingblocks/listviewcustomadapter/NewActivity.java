package com.codingblocks.listviewcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        LinearLayout parent = findViewById(R.id.linearLayout);

        View inflatedView = getLayoutInflater()
                .inflate(R.layout.item_row,parent,false);

        parent.addView(inflatedView);

    }
}
