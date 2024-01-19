package com.example.javaspring.servicesImpl;

import com.example.javaspring.model.Candidato;
import com.example.javaspring.repository.CandidatoRepository;
import com.example.javaspring.services.CandidatoService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;
    @Override
    public Candidato saveCandidato(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    @Override
    @Transactional
    public Candidato getCandidatoById(Integer idCandidato){
        return candidatoRepository.findById(idCandidato).orElse(null);
    }

    @Override
    public List<Candidato> getAllCandidatos(){
        return candidatoRepository.findAll();
    }

    @Override
    public Candidato updateCandidato(Integer idCandidato, Candidato candidatoAtualizado){
            Candidato candidatoExistente = candidatoRepository.findById(idCandidato).orElse(null);
            if (candidatoExistente != null){
                candidatoExistente.setNomeCandidato(candidatoAtualizado.getNomeCandidato());
                candidatoExistente.setCpfCandidato(candidatoAtualizado.getCpfCandidato());
                candidatoExistente.setTelefoneCandidato(candidatoAtualizado.getTelefoneCandidato());
                candidatoExistente.setEmail(candidatoAtualizado.getEmail());

                // Evita que a senha seja atualizada com valor em branco ou vazio
                if (!candidatoAtualizado.getSenha().isBlank() && !candidatoAtualizado.getSenha().isEmpty()) {
                    candidatoExistente.setSenha(candidatoAtualizado.getSenha());
                }

                candidatoExistente.setTipoDeficienciaCandidato(candidatoAtualizado.getTipoDeficienciaCandidato());
                candidatoExistente.setDescDeficienciaCandidato(candidatoAtualizado.getDescDeficienciaCandidato());
                candidatoExistente.setFormacaoAcademicaCandidato(candidatoAtualizado.getFormacaoAcademicaCandidato());
                candidatoExistente.setEnderecoCandidato(candidatoAtualizado.getEnderecoCandidato());
                candidatoExistente.setNumeroResidenciaCandidato(candidatoAtualizado.getNumeroResidenciaCandidato());
                candidatoExistente.setComplementoResidenciaCandidato(candidatoAtualizado.getComplementoResidenciaCandidato());
                candidatoExistente.setBairroCandidato(candidatoAtualizado.getBairroCandidato());
                candidatoExistente.setCidadeCandidato(candidatoAtualizado.getCidadeCandidato());
                candidatoExistente.setEstadoCandidato(candidatoAtualizado.getEstadoCandidato());
                return candidatoRepository.save(candidatoExistente);
            } else {
                throw new RuntimeException("Candidato " + idCandidato + " não encontrado!");
            }
    }



    @Override
    public void deleteCandidato(Integer idCandidato){
        candidatoRepository.deleteById(idCandidato);
    }

}
