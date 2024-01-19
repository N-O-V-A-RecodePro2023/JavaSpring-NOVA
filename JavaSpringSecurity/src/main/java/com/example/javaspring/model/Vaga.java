package com.example.javaspring.model;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVaga;

    @Column(columnDefinition = "TEXT" , nullable=false)
    private String codVaga;

    @Column(columnDefinition = "TEXT" , nullable=false)
    private String nomeVaga;

    @Column(columnDefinition = "TEXT" , nullable=false)
    private String descVaga;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "vaga", fetch = FetchType.LAZY)
    private Set<Candidatura> candidatura;

    public Vaga () {
        super();
    }

    public Vaga(int idVaga, String codVaga, String nomeVaga, String descVaga) {
        super();
        this.idVaga = idVaga;
        this.codVaga = codVaga;
        this.nomeVaga = nomeVaga;
        this.descVaga = descVaga;

    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public String getCodVaga() {
        return codVaga;
    }

    public void setCodVaga(String codVaga) {
        this.codVaga = codVaga;
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public String getDescVaga() {
        return descVaga;
    }

    public void setDescVaga(String descVaga) {
        this.descVaga = descVaga;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
