package br.udesc.workmanagerexample;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DownloadWorker extends Worker {

    public DownloadWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        Log.d("OTES06-->", "DowloadWorker: " + workerParams.getId() + " data:" + workerParams.getInputData());
    }

    @NonNull
    @Override
    public Result doWork() {

        downloadInfo();
        return Result.success();
    }

    private void downloadInfo() {
        Log.d("OTES06-->", "downloadInfo: ");
    }
}
