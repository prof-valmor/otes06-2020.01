package br.edu.oprofvalmor.datastorage.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pessoa {
    @PrimaryKey
    @NonNull
    private String nome;
    private String idade;
    private String texto;

    public Pessoa(@NonNull String nome, @NonNull String idade, @NonNull String texto) {
        this.nome = nome;
        this.idade = idade;
        this.texto = texto;
    }

    public String toString() {
        return "Nome: " + nome + "\n" + "idade: " + idade + "\n" + "texto: " + texto + "\n";
    }

    public String getNome() {
        return nome;
    }
    public String getIdade() {
        return idade;
    }
    public String getTexto() {
        return texto;
    }

}
