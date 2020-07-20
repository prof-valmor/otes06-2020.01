package br.udesc.workmanagerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context ctx = getBaseContext();

        counter++;

        Log.d("OTES06-->", "onCreate: counter: " + counter);
        //
        Button btGo = findViewById(R.id.btGo);
        btGo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Data inputData = new Data.Builder()
                .putString("key_url",
                        "http://www.omdbapi.com/demo.aspx/?t=the+matrix&token=03AOLTBLR0ql57Sox1UvkcXJfSnpnvJUbz_cuK6CIG8NDU62mb7_49EjkwvSCVby-LW4kycGyNOxRAQN1Eeec1pUZprPBE8mozPJFI_XXM3aCkqPnP7h_2wBh77mVmuL2j5Fi5_eRZsgOJbLCUpCfIhdHT230lBQHR-DLJoWa5ouG0hb9ZWOLFuDgFh-vtJxBuoW221VrMCf_OB1Xr2QfhR1KXlli0AKuCnVU7DO24qA9svZvSdw0ieFALt5jfvoCVEYpd-fbPLUoV2RDfX__cI1HzSpjbtXhSZ7ToO25OGcWTHl0HECkAlFu2NezDAP651NueQ5qd7QwP1b17j0VjfFVGI7AZCWMzGWyHuRliZOTUwgoOpfXAKPSe40ihTFlm3Qzr-n7Nw2kdzkW2YEA8Jr3b9p-jWh93d7MzqmV1Yp7L5WVGIAyfZUZKggeqSGn063a-7UuzP01XZrec8nHuFJmejiK9U7u2TOvoxn7BAUqlL0sCNMaE1pc")
                .build();

        Constraints constraints = new Constraints.Builder()
//                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();


        OneTimeWorkRequest otwRequest =
                new OneTimeWorkRequest.Builder(DownloadWorker.class)
                        .setInputData(inputData)
//                        .setConstraints(constraints)
                        .build();
        WorkManager.getInstance(getBaseContext()).enqueue(otwRequest);
        //
//        LiveData<WorkStatus> status =
//                WorkManager.getInstance().getStatusById(otwRequest.getId());
//        status.observe(this, new Observer<WorkStatus>() {
//            @Override
//            public void onChanged(@Nullable WorkStatus workStatus) {
//                if (workStatus != null && workStatus.getState().isFinished()) {
//                    //TODO: adicionar codigo.
//                }
//            }
//        });

    }
}