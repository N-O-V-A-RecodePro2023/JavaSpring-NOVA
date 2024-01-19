package com.example.javaspring.servicesImpl;

import com.example.javaspring.model.Empresa;
import com.example.javaspring.repository.EmpresaRepository;
import com.example.javaspring.services.EmpresaService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    @Transactional
    public Empresa getEmpresaById(Integer idEmpresa) {
        return empresaRepository.findById(idEmpresa).orElse(null);
    }

    @Override
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    @Transactional
    public Empresa getEmpresaByEmail(String email) {
        return empresaRepository.findByEmailEmpresa(email);
    }

    @Override
    public Empresa updateEmpresa(Integer idEmpresa, Empresa empresaAtualizada) {
        Empresa empresaExistente = empresaRepository.findById(idEmpresa).orElse(null);
        if (empresaExistente != null) {
            empresaExistente.setRazaoSocialEmpresa(empresaAtualizada.getRazaoSocialEmpresa());
            empresaExistente.setNomeFantasiaEmpresa(empresaAtualizada.getNomeFantasiaEmpresa());
            empresaExistente.setCnpjEmpresa(empresaAtualizada.getCnpjEmpresa());
            empresaExistente.setTelefoneEmpresa(empresaAtualizada.getTelefoneEmpresa());
            empresaExistente.setEmail(empresaAtualizada.getEmail());

            // Evita que a senha seja atualizada com valor em branco ou vazio
            if (!empresaAtualizada.getSenha().isBlank() && !empresaAtualizada.getSenha().isEmpty()) {
                empresaExistente.setSenha(empresaAtualizada.getSenha());
            }

            empresaExistente.setSeguimentoEmpresa(empresaAtualizada.getSeguimentoEmpresa());
            empresaExistente.setDescSeguimentoEmpresa(empresaAtualizada.getDescSeguimentoEmpresa());
            empresaExistente.setEnderecoEmpresa(empresaAtualizada.getEnderecoEmpresa());
            empresaExistente.setNumeroEmpresa(empresaAtualizada.getNumeroEmpresa());
            empresaExistente.setComplementoEmpresa(empresaAtualizada.getComplementoEmpresa());
            empresaExistente.setBairroEmpresa(empresaAtualizada.getBairroEmpresa());
            empresaExistente.setCidadeEmpresa(empresaAtualizada.getCidadeEmpresa());
            empresaExistente.setEstadoEmpresa(empresaAtualizada.getEstadoEmpresa());
            return empresaRepository.save(empresaExistente);
        } else {
            throw new RuntimeException("Empresa " + idEmpresa + " não encontrado!");
        }
    }

    @Override
    public void deleteEmpresa(Integer idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }

    public boolean empresaSenhaMatches(String senha, Empresa empresa) {
        if (senha.equals(empresa.getSenha())) {
            return true;
        }

        return false;
    }
}