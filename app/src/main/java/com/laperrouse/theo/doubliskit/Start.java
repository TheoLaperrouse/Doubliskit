package com.laperrouse.theo.doubliskit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        Button regles = findViewById(R.id.butRegles);
        Button jouer = findViewById(R.id.butJouer);
        regles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent jouer = new Intent().setClass(getApplicationContext(), Regles.class);
                startActivity(jouer);

            }
        });
        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent jouer = new Intent().setClass(getApplicationContext(), Jouer.class);
                startActivity(jouer);

            }
        });
    }
}
