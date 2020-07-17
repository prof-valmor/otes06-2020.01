package br.udesc.fragmentsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
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
public class Fragment3 extends Fragment {

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroyView() {
        EditText edtAddress;
        //
        edtAddress = getView().findViewById(R.id.edtAddress);
        Cliente.getInstance().setAddress(edtAddress.getText().toString());
        //
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        intent.putExtra(ContactsContract.Intents.Insert.NAME, Cliente.getInstance().getNome());
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, Cliente.getInstance().getPhone());
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, Cliente.getInstance().getEmail());

        getContext().startActivity(intent);
        //
        super.onDestroyView();
    }
}