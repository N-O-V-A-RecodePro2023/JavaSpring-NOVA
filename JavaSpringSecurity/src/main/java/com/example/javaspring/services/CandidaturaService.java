package com.example.javaspring.services;

import com.example.javaspring.model.Candidatura;

import java.util.List;

public interface CandidaturaService {


    Candidatura saveCandidatura(Candidatura candidatura);

    Candidatura getCandidaturaById(Integer idCandidatura);

    List<Candidatura> getAllCandidaturas();

    Candidatura updateCandidatura(Integer idCandidatura, Candidatura candidaturaAtualizado);

    void deleteCandidatura(Integer idCandidatura);


}










