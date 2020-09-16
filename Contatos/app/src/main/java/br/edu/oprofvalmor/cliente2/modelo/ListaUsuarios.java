package br.edu.oprofvalmor.cliente2.modelo;

import androidx.databinding.ObservableField;

import java.util.List;

public class ListaUsuarios {
    private static ObservableField<List<String>> listaDeUsuarios = new ObservableField<List<String>>();

    public static ObservableField<List<String>> getListaDeUsuarios() {
        return listaDeUsuarios;
    }
}
