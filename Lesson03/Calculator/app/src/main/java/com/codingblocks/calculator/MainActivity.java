package com.codingblocks.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Float numberOne, numberTwo;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sum(View view) {
        EditText etOne = findViewById(R.id.etOne);
        EditText etTwo = findViewById(R.id.etTwo);

        String etOneString = etOne.getText().toString();
        String etTwoString = etTwo.getText().toString();

        numberOne = Float.parseFloat(etOneString);
        numberTwo = Float.parseFloat(etTwoString);

        Float result = numberOne + numberTwo;

        tvResult = findViewById(R.id.textView);

        tvResult.setText(result.toString());
    }

    public void subtract(View view) {
    }

    public void divide(View view) {
    }

    public void multiply(View view) {
    }
}
