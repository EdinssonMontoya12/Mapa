package com.edinsson.mapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irMapa(String name){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("location", name);
        startActivity(intent);
    }

    public void destino(View view){
        if (view.equals(findViewById(R.id.valle_de_reyes))) {
            irMapa("valleDeReyes");
        }
        if (view.equals(findViewById(R.id.vaticano))) {
            irMapa("vaticano");
        }
        if (view.equals(findViewById(R.id.torre_eiffle))) {
            irMapa("torreEiffel");
        }
        if (view.equals(findViewById(R.id.hollywood))) {
            irMapa("hollywood");
        }
    }
}