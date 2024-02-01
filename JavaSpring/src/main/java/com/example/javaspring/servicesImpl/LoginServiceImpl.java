package com.example.javaspring.servicesImpl;

import com.example.javaspring.interfaces.Usuario;
import com.example.javaspring.repository.CandidatoRepository;
import com.example.javaspring.repository.EmpresaRepository;
import com.example.javaspring.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = empresaRepository.findByEmailEmpresa(email);
        if (usuario == null) {
            usuario = candidatoRepository.findByEmailCandidato(email);
        }
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        } else {
            return null;
        }
    }
}