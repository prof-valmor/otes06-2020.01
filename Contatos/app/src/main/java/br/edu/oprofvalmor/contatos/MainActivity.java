package br.edu.oprofvalmor.contatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Contato> listaContatos = new ArrayList<>(1);

    public HashMap<String, List<String>> listaMensagens = new HashMap<>(1);


    class MyAdapter extends BaseAdapter {

        // override other abstract methods here

        @Override
        public int getCount() {
            //return Model.getInstance().getListaUsuarios().size();
            return listaContatos.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
//            return Model.getInstance().getListaUsuarios().get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.linha_usuario, container, false);
            }
            Contato contato = listaContatos.get(position);

            ((TextView) convertView.findViewById(R.id.txtHorario)).setText(contato.horario);
            ((TextView) convertView.findViewById(R.id.txtUserName)).setText(contato.nome);

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        listaContatos.add(new Contato("Valmor", "10:12"));
        listaContatos.add(new Contato("Leticia", "08:12"));
        listaContatos.add(new Contato("Matheus", "09:12"));
        listaContatos.add(new Contato("Davi", "09:12"));
        ///
        ///

        ///
//        List mensagens  = listaMensagens.get("o.professor");
//        if(mensagens == null) {
//            listaMensagens.put("o.professor", mensagens = new ArrayList<String>(1));
//        }
//        mensagens.add("teste 124312413 2");


        //
        ListView listaContato = findViewById(R.id.listaContatos);

        listaContato.setAdapter(new MyAdapter());
    }
}