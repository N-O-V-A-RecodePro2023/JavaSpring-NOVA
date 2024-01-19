package com.example.javaspring.model;
import jakarta.persistence.*;


@Entity
@Table
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContato;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="nome_contato")
    private String nomeContato;
    @Column(columnDefinition = "TEXT" , nullable=false, name ="email_contato")
    private String emailContato;
    @Column(columnDefinition = "TEXT" , nullable=false, name ="assunto_contato")
    private String assuntoContato;
    @Column(columnDefinition = "TEXT" , nullable=false, name ="mensagem_contato")
    private String mensagemContato;

    public Contato () {
        super();
    }

    public Contato(int idContato, String nomeContato, String emailContato, String assuntoContato,
                   String mensagemContato) {
        super();
        this.idContato = idContato;
        this.nomeContato = nomeContato;
        this.emailContato = emailContato;
        this.assuntoContato = assuntoContato;
        this.mensagemContato = mensagemContato;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getAssuntoContato() {
        return assuntoContato;
    }

    public void setAssuntoContato(String assuntoContato) {
        this.assuntoContato = assuntoContato;
    }

    public String getMensagemContato() {
        return mensagemContato;
    }

    public void setMensagemContato(String mensagemContato) {
        this.mensagemContato = mensagemContato;
    }



}
