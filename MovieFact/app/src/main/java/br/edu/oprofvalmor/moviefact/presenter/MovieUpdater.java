package br.edu.oprofvalmor.moviefact.presenter;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieUpdater extends Worker {
    private static final String apiKeyPrefix = "&apikey=";
    private static final String apiKeySuffix = "&";
    private String url = "http://www.omdbapi.com/?t=";
    RequestQueue queue;
    public MovieUpdater(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

        String keyWords = workerParams.getInputData().getString("keywords").toLowerCase();
        String apiKey = workerParams.getInputData().getString("apikey");

        String words[] = keyWords.split(" ");
        url+= words[0];
        for(int i = 1; i < words.length; i++) {
            url+= "+"+words[i];
        }
        url+= apiKeyPrefix;
        url+= apiKey;
        url+= apiKeySuffix;
        // Request a string response from the provided URL.
        queue = Volley.newRequestQueue(context);

    }

    @NonNull
    @Override
    public Result doWork() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Parsing and setting the fields.
                        Log.d("VM", "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Movie.update(getApplicationContext(), jsonObject);
                        }catch (JSONException e) {
                            Log.d("VM", "Exception: " + e.getMessage());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    Movie.update(getApplicationContext(), new JSONObject(""));
                }catch (JSONException e) {
                    Log.d("VM", "Exception: " + e.getMessage());
                }
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        return Result.success();
    }
}
