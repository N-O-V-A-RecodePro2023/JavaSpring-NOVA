package com.example.javaspring.servicesImpl;


import com.example.javaspring.model.Candidatura;
import com.example.javaspring.repository.CandidaturaRepository;
import com.example.javaspring.services.CandidaturaService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidaturaServiceImpl implements CandidaturaService {

    @Autowired
    public CandidaturaRepository candidaturaRepository;

    @Override
    public Candidatura saveCandidatura(Candidatura candidatura) {
        return candidaturaRepository.save(candidatura);
    }

    @Override
    @Transactional
    public Candidatura getCandidaturaById(Integer idCandidatura){
        return candidaturaRepository.findById(idCandidatura).orElse(null);
    }

    @Override
    public List<Candidatura> getAllCandidaturas(){
        return candidaturaRepository.findAll();
    }

    @Override
    public Candidatura updateCandidatura(Integer idCandidatura, Candidatura candidaturaAtualizada){
        Candidatura candidaturaExistente = candidaturaRepository.findById(idCandidatura).orElse(null);
        if (candidaturaExistente != null){
            candidaturaExistente.setStatusCandidatura(candidaturaAtualizada.getStatusCandidatura());
            candidaturaExistente.setCandidato(candidaturaAtualizada.getCandidato());
            candidaturaExistente.setVaga(candidaturaAtualizada.getVaga());
            return candidaturaRepository.save(candidaturaExistente);
        } else {
            throw new RuntimeException("Candidatura " + idCandidatura + " não encontrado!");
        }
    }


    @Override
    public void deleteCandidatura(Integer idCandidatura){
        candidaturaRepository.deleteById(idCandidatura);

    }






}
