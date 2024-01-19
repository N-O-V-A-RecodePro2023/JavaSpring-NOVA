package com.example.javaspring.services;

import com.example.javaspring.model.Candidato;


import java.util.List;

public interface CandidatoService {

    Candidato saveCandidato(Candidato candidato);

    Candidato getCandidatoById(Integer idCandidato);

    List<Candidato> getAllCandidatos();

    Candidato updateCandidato(Integer idCandidato, Candidato candidatoAtualizado);

    void deleteCandidato(Integer idCandidato);


}
