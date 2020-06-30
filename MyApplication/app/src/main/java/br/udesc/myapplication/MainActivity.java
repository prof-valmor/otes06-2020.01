package br.udesc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import br.udesc.modelo.Geladeira;
import br.udesc.modelo.TemperaturaListener;

public class MainActivity extends AppCompatActivity {

    public SeekBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Button btSelecionar = findViewById(R.id.btOk);
        bar = findViewById(R.id.seekBar);
        bar.setProgress(Geladeira.getInstance().getTemperaturaSelecionada());
        //
        //Adicionando os eventos do botao
        btSelecionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Geladeira.getInstance().incrementarSelecaoDeTemperatura();
            }
        });

        Geladeira.getInstance().addTemperaturaListener(new TemperaturaListener() {
            @Override
            public void onTemperaturaChange(int temperatura) {
                bar.setProgress(temperatura);
            }
        });

    }
}
