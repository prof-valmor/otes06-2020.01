package br.edu.oprofvalmor.datastorage.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PessoaDao {
    @Query("select * from Pessoa")
    List<Pessoa> getAll();
    @Insert
    void addPessoa(Pessoa p);
    @Delete
    void removePessoa(Pessoa p);
}
