package br.edu.oprofvalmor.datastorage.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pessoa.class}, version = 1)
public abstract class MyDB extends RoomDatabase {

    public abstract PessoaDao pessoaDao();
}
