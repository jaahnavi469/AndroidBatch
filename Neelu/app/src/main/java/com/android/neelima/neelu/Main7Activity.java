package com.android.neelima.neelu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity {
TextView t;
ImageView i;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        t=(TextView)findViewById(R.id.t) ;

        b=(Button)findViewById(R.id.b);
        i=(ImageView)findViewById(R.id.i) ;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main7Activity.this,Main8Activity.class);
                startActivity(i);
            }
        });
    }
}
