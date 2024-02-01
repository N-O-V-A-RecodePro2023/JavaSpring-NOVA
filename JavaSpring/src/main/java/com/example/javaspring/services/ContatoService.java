package com.example.javaspring.services;

import com.example.javaspring.model.Contato;

import java.util.List;

public interface ContatoService {


    Contato saveContato(Contato contato);

    List<Contato> getAllContatos();


}










