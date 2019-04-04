package com.codingblocks.onclicklisteners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    class xyz extends Fruit{
//        @Override
//        public Boolean isEdible() {
//            return true;
//        }
//    }
//
//    class abc implements View.OnClickListener{
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(getBaseContext(),MainActivity.class);
//        }
//    }

//    View.OnClickListener onClickListener =
//            new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    switch (v.getId()) {
//                        case R.id.tvHello:
//                            Log.e("TAG", "Message");
//                            break;
//                        case R.id.tvHello1:
//                            Intent i = new Intent(getBaseContext(),
//                                    MainActivity.class);
//                            startActivity(i);
//                            break;
//                    }
//                }
//            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello = findViewById(R.id.tvHello);
        TextView tvHello1 = findViewById(R.id.tvHello1);
//        Fruit f = new xyz();
//        tvHello1.setOnClickListener(onClickListener);
        tvHello.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvHello:
                Log.e("TAG", "Message");
                break;
            case R.id.tvHello1:
                Intent i = new Intent(getBaseContext(),
                        MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
