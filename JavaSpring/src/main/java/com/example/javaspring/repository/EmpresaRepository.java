package com.example.javaspring.repository;

import com.example.javaspring.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    Empresa findByEmailEmpresa(String email);
}
