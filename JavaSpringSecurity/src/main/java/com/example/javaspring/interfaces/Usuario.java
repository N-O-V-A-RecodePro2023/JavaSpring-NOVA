package com.example.javaspring.interfaces;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public interface Usuario {

    public int getId();

    public void setId(int id);

    String getEmail();

    void setEmail(String email);

    String getSenha();

    void setSenha(String senha);
}
