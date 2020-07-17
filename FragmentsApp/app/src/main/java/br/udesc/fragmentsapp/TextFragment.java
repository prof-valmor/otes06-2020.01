package br.udesc.fragmentsapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.udesc.modelo.Cliente;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class TextFragment extends Fragment {

    EditText edtNome;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        edtNome = getView().findViewById(R.id.edtNome);

        edtNome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                edtNome.setText("");
            }
        });

    }

    @Override
    public void onDestroyView() {
        //
        Cliente.getInstance().setNome(edtNome.getText().toString());
        super.onDestroyView();
    }
}