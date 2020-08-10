package br.edu.oprofvalmor.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btToast, btDialog;
    AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        btToast = findViewById(R.id.btToast);
        btDialog = findViewById(R.id.btDialog);
        //
        dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Dialog 1")
//                .setMessage("Mostrando o dialogo.")
                .setItems(new CharSequence[]{"SC", "PR", "RS"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("otes", "onClick: setItems : " + i);
                    }
                });
//                .setPositiveButton("OKAY", new Dialog.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Log.d("otes", "onClick: Positive AlertDialog");
//                    }
//                })
//                .setNeutralButton("Neutral", new Dialog.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Log.d("otes", "onClick: Neutral AlertDialog");
//                    }
//                });

        //
        dialog.create();
        //
        btToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("otes", "onClick: btToast");
                Toast.makeText(getApplicationContext(), "informacao sendo apresentada...", Toast.LENGTH_LONG)
                        .show();
            }
        });

        btDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("otes", "onClick: btDialog");
                dialog.show();
            }
        });
        //
        //
        String mensagem = "{ \"online-users\": [ \"broadcast\", \"o.professor\", \"o.aluno\", \"outro.aluno\", \"mais.um.aluno\" ] }";
        try {
            JSONObject json = new JSONObject(mensagem);
            //Log.d("otes", "jsonObject: " + json.toString());
            if(json.has("online-users")) {
                Log.d("otes", " Mensagem de usuarios online");
                JSONArray usuarios = json.getJSONArray("online-users");
                Log.d("otes", " array de usuarios: " + usuarios.toString());
            }
        }
        catch(JSONException e) {
            Log.d("otes", "parsing JSON: " + e.getMessage());
        }

    }
}