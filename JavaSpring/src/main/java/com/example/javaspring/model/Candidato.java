package com.example.javaspring.model;

import com.example.javaspring.interfaces.Usuario;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table
public class Candidato implements Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCandidato;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="nome_candidato")
    private String nomeCandidato;

    @Column(columnDefinition = "TEXT" , nullable=false, unique = true, name ="cpf_candidato")
    private String cpfCandidato;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="telefone_candidato")
    private String telefoneCandidato;

    @Column(columnDefinition = "TEXT" , nullable=false, unique = true, name ="email_candidato")
    private String emailCandidato;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="senha_candidato")
    private String senhaCandidato;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="tipo_deficiencia")
    private String tipoDeficienciaCandidato;

    @Column(columnDefinition = "TEXT" , name ="desc_deficiencia")
    private String descDeficienciaCandidato;

    @Column(columnDefinition = "TEXT" , name ="formacao_academica")
    private String formacaoAcademicaCandidato;

    @Column(columnDefinition = "TEXT" , name ="endereco_candidato")
    private String enderecoCandidato;

    @Column(columnDefinition = "TEXT" , name ="numero_end_candidato")
    private String numeroResidenciaCandidato;

    @Column(columnDefinition = "TEXT" , name ="complemento_end_candidato")
    private String complementoResidenciaCandidato;

    @Column(columnDefinition = "TEXT" , name ="bairro_candidato")
    private String bairroCandidato;

    @Column(columnDefinition = "TEXT" , name ="cidade_candidato")
    private String cidadeCandidato;

    @Column(columnDefinition = "TEXT" , name ="estado_candidato")
    private String estadoCandidato;


    @OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY)
    private Set<Candidatura> candidatura;

    public Candidato () {

    }

    public Candidato(int idCandidato, String nomeCandidato, String cpfCandidato, String telefoneCandidato,
                     String emailCandidato, String senhaCandidato, String tipoDeficienciaCandidato,
                     String descDeficienciaCandidato, String formacaoAcademicaCandidato, String enderecoCandidato,
                     String numeroResidenciaCandidato, String complementoResidenciaCandidato, String bairroCandidato,
                     String cidadeCandidato, String estadoCandidato) {
        super();

        this.idCandidato = idCandidato;
        this.nomeCandidato = nomeCandidato;
        this.cpfCandidato = cpfCandidato;
        this.telefoneCandidato = telefoneCandidato;
        this.emailCandidato = emailCandidato;
        this.senhaCandidato = senhaCandidato;
        this.tipoDeficienciaCandidato = tipoDeficienciaCandidato;
        this.descDeficienciaCandidato = descDeficienciaCandidato;
        this.formacaoAcademicaCandidato = formacaoAcademicaCandidato;
        this.enderecoCandidato = enderecoCandidato;
        this.numeroResidenciaCandidato = numeroResidenciaCandidato;
        this.complementoResidenciaCandidato = complementoResidenciaCandidato;
        this.bairroCandidato = bairroCandidato;
        this.cidadeCandidato = cidadeCandidato;
        this.estadoCandidato = estadoCandidato;
    }

    public int getId() {
        return idCandidato;
    }

    public void setId(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public String getCpfCandidato() {
        return cpfCandidato;
    }

    public void setCpfCandidato(String cpfCandidato) {
        this.cpfCandidato = cpfCandidato;
    }

    public String getTelefoneCandidato() {
        return telefoneCandidato;
    }

    public void setTelefoneCandidato(String telefoneCandidato) {
        this.telefoneCandidato = telefoneCandidato;
    }

    public String getEmail() {
        return emailCandidato;
    }

    public void setEmail(String emailCandidato) {
        this.emailCandidato = emailCandidato;
    }

    public String getSenha() {
        return senhaCandidato;
    }

    public void setSenha(String senhaCandidato) {
        this.senhaCandidato = senhaCandidato;
    }

    public String getTipoDeficienciaCandidato() {
        return tipoDeficienciaCandidato;
    }

    public void setTipoDeficienciaCandidato(String tipoDeficienciaCandidato) {
        this.tipoDeficienciaCandidato = tipoDeficienciaCandidato;
    }

    public String getDescDeficienciaCandidato() {
        return descDeficienciaCandidato;
    }

    public void setDescDeficienciaCandidato(String descDeficienciaCandidato) {
        this.descDeficienciaCandidato = descDeficienciaCandidato;
    }

    public String getFormacaoAcademicaCandidato() {
        return formacaoAcademicaCandidato;
    }

    public void setFormacaoAcademicaCandidato(String formacaoAcademicaCandidato) {
        this.formacaoAcademicaCandidato = formacaoAcademicaCandidato;
    }

    public String getEnderecoCandidato() {
        return enderecoCandidato;
    }

    public void setEnderecoCandidato(String enderecoCandidato) {
        this.enderecoCandidato = enderecoCandidato;
    }

    public String getNumeroResidenciaCandidato() {
        return numeroResidenciaCandidato;
    }

    public void setNumeroResidenciaCandidato(String numeroResidenciaCandidato) {
        this.numeroResidenciaCandidato = numeroResidenciaCandidato;
    }

    public String getComplementoResidenciaCandidato() {
        return complementoResidenciaCandidato;
    }

    public void setComplementoResidenciaCandidato(String complementoResidenciaCandidato) {
        this.complementoResidenciaCandidato = complementoResidenciaCandidato;
    }

    public String getBairroCandidato() {
        return bairroCandidato;
    }

    public void setBairroCandidato(String bairroCandidato) {
        this.bairroCandidato = bairroCandidato;
    }

    public String getCidadeCandidato() {
        return cidadeCandidato;
    }

    public void setCidadeCandidato(String cidadeCandidato) {
        this.cidadeCandidato = cidadeCandidato;
    }

    public String getEstadoCandidato() {
        return estadoCandidato;
    }

    public void setEstadoCandidato(String estadoCandidato) {
        this.estadoCandidato = estadoCandidato;
    }



}
