package com.example.javaspring.repository;

import com.example.javaspring.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

    Candidato findByEmailCandidato(String email);

}