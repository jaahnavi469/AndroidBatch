package com.android.stepinleads.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("battlecasuality", "onResponse: "+response, null);
                try {
                    progress.hide();

                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Saved successfully")
                                .setNegativeButton("OK", null)
                                .create()
                                .show();

                    }

                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();

                    }

                }

                catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(e.getMessage().toString())
                            .setNegativeButton("Retry", null)
                            .create()
                            .show();
                }
            }
        };
        progress=new ProgressDialog(MainActivity.this);
        progress.setIndeterminate(true);
        progress.setTitle("Validating");
        progress.setMessage("Please wait...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
        Entry registerRequest=new Entry("Bindhu",responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(registerRequest);
    }
    }
