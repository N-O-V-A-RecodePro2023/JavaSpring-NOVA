package com.example.javaspring.services;

import com.example.javaspring.model.Vaga;

import java.util.List;

public interface VagaService {

    Vaga saveVaga(Vaga vaga);

    Vaga getVagaById(Integer idVaga);

    List<Vaga> getAllVagas();

    Vaga updateVaga(Integer idVaga, Vaga vagaAtualizado);

    void deleteVaga(Integer idVaga);



}









