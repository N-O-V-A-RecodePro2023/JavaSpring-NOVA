package com.example.javaspring.services;

import com.example.javaspring.model.Empresa;

import java.util.List;

public interface EmpresaService {


    Empresa saveEmpresa(Empresa empresa);

    Empresa getEmpresaById(Integer idEmpresa);

    List<Empresa> getAllEmpresas();

    Empresa getEmpresaByEmail(String email);

    Empresa updateEmpresa(Integer idEmpresa, Empresa empresaAtualizado);

    void deleteEmpresa(Integer idEmpresa);

    public boolean empresaSenhaMatches(String senha, Empresa empresa);
}
