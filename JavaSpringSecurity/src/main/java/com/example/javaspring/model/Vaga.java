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

    @Column(columnDefinition = "TEXT" , nullable=false)
    private String localVaga;

    @Column(columnDefinition = "TEXT" , nullable=false)
    private String modalidadeVaga;

    @Column(columnDefinition = "INT" , nullable=false)
    private int qtdVaga;

    @Column(columnDefinition = "DOUBLE" , nullable=false)
    private double salarioVaga;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "vaga", fetch = FetchType.LAZY)
    private Set<Candidatura> candidatura;

    public Vaga () {
        super();
    }

    public Vaga(int idVaga, String codVaga, String nomeVaga, String descVaga, String localVaga,
                String modalidadeVaga, int qtdVaga, double salarioVaga, Empresa empresa) {
        this.idVaga = idVaga;
        this.codVaga = codVaga;
        this.nomeVaga = nomeVaga;
        this.descVaga = descVaga;
        this.localVaga = localVaga;
        this.modalidadeVaga = modalidadeVaga;
        this.qtdVaga = qtdVaga;
        this.salarioVaga = salarioVaga;
        this.empresa = empresa;
    }

//    public Vaga(int idVaga, String codVaga, String nomeVaga, String descVaga, Empresa empresa) {
//        super();
//        this.idVaga = idVaga;
//        this.codVaga = codVaga;
//        this.nomeVaga = nomeVaga;
//        this.descVaga = descVaga;
//        this.empresa = empresa;
//    }

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

    public String getLocalVaga() {
        return localVaga;
    }

    public void setLocalVaga(String localVaga) {
        this.localVaga = localVaga;
    }

    public String getModalidadeVaga() {
        return modalidadeVaga;
    }

    public void setModalidadeVaga(String modalidadeVaga) {
        this.modalidadeVaga = modalidadeVaga;
    }

    public int getQtdVaga() {
        return qtdVaga;
    }

    public void setQtdVaga(int qtdVagas) {
        this.qtdVaga = qtdVagas;
    }

    public double getSalarioVaga() {
        return salarioVaga;
    }

    public void setSalarioVaga(double valorSalario) {
        this.salarioVaga = valorSalario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
