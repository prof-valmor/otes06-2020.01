package br.edu.oprofvalmor.moviefact.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

/**
 * Classe que processa os dados recebidos do servico.
 */
public class Movie {
    private static final String TAG = Movie.class.getSimpleName();

    private static MutableLiveData<Bitmap> poster = new MutableLiveData<Bitmap>();
    private static MutableLiveData<String> title = new MutableLiveData<>();
    private static MutableLiveData<String> director = new MutableLiveData<>();

    public static void  update(Context context, JSONObject movieData) throws JSONException {
        Log.d(TAG, "update: " + movieData.toString());
        title.postValue(movieData.optString("Title", "Not Found"));
        director.postValue(movieData.optString("Director", ""));
        String imageUrl = movieData.getString("Poster");
        //
        ImageRequest imageRequest = new ImageRequest(imageUrl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                poster.postValue(response);
            }
        },0,0, ImageView.ScaleType.CENTER_CROP,null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Add the request to the RequestQueue.
        Volley.newRequestQueue(context).add(imageRequest);

    }

    public static MutableLiveData<Bitmap> getPoster() {
        return poster;
    }


    public static MutableLiveData<String> getTitle() {
        return title;
    }

    public static MutableLiveData<String> getDirector() {
        return director;
    }

    public static Drawable loadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}
