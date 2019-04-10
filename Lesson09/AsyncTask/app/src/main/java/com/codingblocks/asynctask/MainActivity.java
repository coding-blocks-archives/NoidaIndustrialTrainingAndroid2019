package com.codingblocks.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Boolean isTaskStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.btnStart);
        final CountTask countTask = new CountTask();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTaskStarted || countTask.getStatus() != AsyncTask.Status.RUNNING) {
                    countTask.execute(1000000000L, 20000000L, 30000000L);
                    isTaskStarted = true;
                }
            }
        });
    }

    class CountTask extends AsyncTask<Long, String, String> {

        //UI Thread
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            TextView tvStatus = findViewById(R.id.tvStatus);
            tvStatus.setText("Counting ...");
            ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
        }

        //Background thread
        @Override
        protected String doInBackground(Long... longs) {
            Long limit = longs[0];

            for (long i = 0; i < limit; i++) {
                if (i % 100000 == 0) {
                    publishProgress("" + i);
                }
            }
            return "Counting till " + limit + " Done!";
        }

        //UI thread
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            TextView textView = findViewById(R.id.tvStatus);
            textView.setText,sdfdsfsdfdsfd(values[0]);
        }

        //UI Thread
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setVisibility(View.INVISIBLE);
            TextView tvResult = findViewById(R.id.tvStatus);
            tvResult.setText(s);
        }

    }

}
