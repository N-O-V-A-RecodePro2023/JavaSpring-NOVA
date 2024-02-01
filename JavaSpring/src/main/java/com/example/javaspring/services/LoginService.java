package com.example.javaspring.services;

import com.example.javaspring.interfaces.Usuario;

public interface LoginService {
    public Usuario autenticar(String email, String senha);
}