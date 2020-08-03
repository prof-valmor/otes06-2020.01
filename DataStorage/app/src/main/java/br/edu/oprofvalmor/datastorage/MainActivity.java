package br.edu.oprofvalmor.datastorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.edu.oprofvalmor.datastorage.model.MyDB;
import br.edu.oprofvalmor.datastorage.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    EditText txtNome, txtIdade, txtText;
    MyDB oBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Criando o DB
        oBanco = Room.databaseBuilder(getApplicationContext(),
                MyDB.class, "banco-das-pessoas").build();

        //
        txtNome = findViewById(R.id.edtNome);
        txtIdade = findViewById(R.id.edtIdade);
        txtText = findViewById(R.id.edtText);

        ((Button)findViewById(R.id.btInterno)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarNoData(new Pessoa(txtNome.getText().toString(), txtIdade.getText().toString(), txtText.getText().toString()));
            }
        });

        ((Button)findViewById(R.id.btRoom)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarRoom(new Pessoa(txtNome.getText().toString(), txtIdade.getText().toString(), txtText.getText().toString()));
            }
        });

        ((Button)findViewById(R.id.btSP)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               salvarSharedPreferences(new Pessoa(txtNome.getText().toString(), txtIdade.getText().toString(), txtText.getText().toString()));
            }
        });

        ((Button)findViewById(R.id.btExterno)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarNoSDCard(new Pessoa(txtNome.getText().toString(), txtIdade.getText().toString(), txtText.getText().toString()));
            }
        });
    }

    private void salvarSharedPreferences(Pessoa pessoa) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nome", pessoa.getNome());
        editor.putString("idade", pessoa.getIdade());
        editor.putString("texto", pessoa.getTexto());
        if(editor.commit()) {
            Toast.makeText(getBaseContext(), "Armazenado no SP", Toast.LENGTH_LONG).show();
        }
    }

    private void salvarNoData(Pessoa pessoa) {
        File file = new File(getBaseContext().getFilesDir(), Pessoa.class.getSimpleName() + ".txt");
        // Salva no arquivo.
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(pessoa.toString());

            writer.close();
            Toast.makeText(getBaseContext(), "Conteudo armazenado em " + getBaseContext().getFilesDir(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.d("OTES06", "erro no salvarNoData: " + e.getMessage());
        }

    }

    private void salvarNoSDCard(Pessoa pessoa) {
        File file = new File(getBaseContext().getExternalFilesDir(null), Pessoa.class.getSimpleName() + ".txt");
        // Salva no arquivo.
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(pessoa.toString());
            writer.close();

            Toast.makeText(getBaseContext(), "Conteudo armazenado em " + getBaseContext().getExternalFilesDir(null).getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.d("OTES06", "erro no salvarNoSDCard: " + e.getMessage());
        }
    }

    private void salvarRoom(final Pessoa pessoa) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                oBanco.pessoaDao().addPessoa(pessoa);

                List<Pessoa> lista = oBanco.pessoaDao().getAll();
                for(Pessoa p : lista) {
                    Log.d("-->PESSOA", "run: " + p.toString());
                }

            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}