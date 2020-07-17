package br.udesc.fragmentsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import br.udesc.modelo.Cliente;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {


    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((TextView)(getView().findViewById(R.id.txtHello))).setText("Olah " + Cliente.getInstance().getNome());
    }

    @Override
    public void onDestroyView() {
        EditText edtEmail;
        EditText edtPhone;
        //
        edtEmail = getView().findViewById(R.id.edtEmail);
        edtPhone = getView().findViewById(R.id.edtPhone);

        Cliente.getInstance().setEmail(edtEmail.getText().toString());
        Cliente.getInstance().setPhone(edtPhone.getText().toString());

        super.onDestroyView();
    }
}