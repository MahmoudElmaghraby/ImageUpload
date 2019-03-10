package com.mrpistonapp2.android.imageupload;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyTask extends AsyncTask<Void, Integer, String> {

    Context context ;
    TextView textView ;
    Button button ;
    RecyclerView recyclerView ;
    ProgressDialog progressDialog ;

    public MyTask(Context context, TextView textView, Button button, RecyclerView recyclerView) {
        this.context = context;
        this.textView = textView;
        this.button = button;
        this.recyclerView = recyclerView;
    }

    @Override
    protected String doInBackground(Void... voids) {

        int i = 0 ;
        synchronized (this){

            while (i<5){

                try {
                    wait(1000);
                    i++ ;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        return "Download complete...";
    }

    @Override
    protected void onPreExecute() {

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Download in process...");
        progressDialog.setMax(4);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.hide();
        recyclerView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        progressDialog.setProgress(progress);
        textView.setText("Download in process....");
    }
}
