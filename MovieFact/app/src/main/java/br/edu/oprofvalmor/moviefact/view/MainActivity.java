package br.edu.oprofvalmor.moviefact.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.oprofvalmor.moviefact.presenter.MovieUpdater;

public class MainActivity extends AppCompatActivity {
    private EditText edtSearchWord;
    private EditText edtApiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSearchWord = findViewById(R.id.edtNome);
        edtApiKey = findViewById(R.id.edtApiKey);

        Button btGo = findViewById(R.id.btGo);
        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data inputData = new Data.Builder()
                        .putString("keywords",
                                edtSearchWord.getText().toString())
                        .putString("apikey", edtApiKey.getText().toString())
                        .build();

//                Constraints constraints = new Constraints.Builder()
////                .setRequiredNetworkType(NetworkType.CONNECTED)
//                        .build();


                OneTimeWorkRequest otwRequest =
                        new OneTimeWorkRequest.Builder(MovieUpdater.class)
                                .setInputData(inputData)
//                        .setConstraints(constraints)
                                .build();
                WorkManager.getInstance(getBaseContext()).enqueue(otwRequest);
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, new MovieData());
        ft.commit();
    }
}