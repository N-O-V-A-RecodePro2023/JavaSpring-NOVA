package com.example.javaspring.model;
import jakarta.persistence.*;

@Entity
@Table
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCandidatura;
    @Column(columnDefinition = "TEXT")
    private String statusCandidatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vaga")
    private Vaga vaga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidato")
    private Candidato candidato;


    public Candidatura () {
        super();
    }

    public Candidatura(int idCandidatura, Vaga vaga, Candidato candidato, String statusCandidatura) {
        super();
        this.idCandidatura = idCandidatura;
        this.vaga = vaga;
        this.candidato = candidato;
        this.statusCandidatura = statusCandidatura;
    }

    public int getIdCandidatura() {
        return idCandidatura;
    }

    public void setIdCandidatura(int idCandidatura) {
        this.idCandidatura = idCandidatura;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String getStatusCandidatura() {
        return statusCandidatura;
    }

    public void setStatusCandidatura(String statusCandidatura) {
        this.statusCandidatura = statusCandidatura;
    }


}
