package com.example.javaspring.servicesImpl;

import com.example.javaspring.model.Contato;
import com.example.javaspring.repository.ContatoRepository;
import com.example.javaspring.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Override
    public Contato saveContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public List<Contato> getAllContatos(){
        return contatoRepository.findAll();
    }



}
