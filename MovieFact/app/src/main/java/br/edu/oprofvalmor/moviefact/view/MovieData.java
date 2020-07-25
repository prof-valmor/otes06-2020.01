package br.edu.oprofvalmor.moviefact.view;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.oprofvalmor.moviefact.presenter.Movie;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MovieData extends Fragment {
    TextView txtTitle;
    TextView txtDirector;
    ImageView poster;

    public MovieData() {
        // Required empty public constructor
    }

    public void refresh() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_data, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        txtTitle = getActivity().findViewById(R.id.txtTitle);
        txtDirector = getActivity().findViewById(R.id.txtDirector);
        poster = getActivity().findViewById(R.id.poster);
        Movie.getDirector().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtDirector.setText(s);
            }
        });

        Movie.getTitle().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtTitle.setText(s);
            }
        });

        Movie.getPoster().observe(this, new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                poster.setImageBitmap(bitmap);
            }
        });

    }
}