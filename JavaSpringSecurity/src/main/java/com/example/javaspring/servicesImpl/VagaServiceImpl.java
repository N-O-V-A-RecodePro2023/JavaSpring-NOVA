package com.example.javaspring.servicesImpl;

import com.example.javaspring.model.Vaga;
import com.example.javaspring.repository.VagaRepository;
import com.example.javaspring.services.VagaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VagaServiceImpl implements VagaService{

    @Autowired
    private VagaRepository vagaRepository;

    @Override
    public Vaga saveVaga(Vaga vaga) {
        return vagaRepository.save(vaga);
    }


    @Override
    @Transactional
    public Vaga getVagaById(Integer idVaga){
        return vagaRepository.findById(idVaga).orElse(null);
    }

    @Override
    public List<Vaga> getAllVagas(){
        return vagaRepository.findAll();
    }

    @Override
    public Vaga updateVaga(Integer idVaga, Vaga vagaAtualizada){
        Vaga vagaExistente = vagaRepository.findById(idVaga).orElse(null);
        if (vagaExistente != null){
            vagaExistente.setCodVaga(vagaAtualizada.getCodVaga());
            vagaExistente.setNomeVaga(vagaAtualizada.getNomeVaga());
            vagaExistente.setDescVaga(vagaAtualizada.getDescVaga());
            return vagaRepository.save(vagaExistente);
        } else {
            throw new RuntimeException("Vaga " + idVaga + " não encontrado!");
        }
    }


    @Override
    public void deleteVaga(Integer idVaga){
        vagaRepository.deleteById(idVaga);
    }











}
