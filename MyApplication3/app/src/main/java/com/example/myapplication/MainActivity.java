package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private int cliques;
    private static int oncreate = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliques = 0;
        oncreate++;
        Log.d(TAG, "onCreate: " + oncreate);

        Button bt = findViewById(R.id.btOk);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = findViewById(R.id.txtHello);
                cliques++;
                txt.setText("Botao foi pressionado: " + cliques + "vezes");
                Log.d(TAG, "onClick: " + cliques);
            }
        });

    }


}
