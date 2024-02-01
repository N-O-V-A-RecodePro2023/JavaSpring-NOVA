package com.example.javaspring.model;
import com.example.javaspring.interfaces.Usuario;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Empresa implements Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="razao_social")
    private String razaoSocialEmpresa;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="nome_fantasia")
    private String nomeFantasiaEmpresa;

    @Column(columnDefinition = "TEXT" , nullable=false, unique = true, name ="cnpj")
    private String cnpjEmpresa;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="telefone_empresa")
    private String telefoneEmpresa;

    @Column(columnDefinition = "TEXT" , nullable=false, unique = true, name ="email_empresa")
    private String emailEmpresa;

    @Column(columnDefinition = "TEXT" , nullable=false, name ="senha_empresa")
    private String senhaEmpresa;

    @Column(columnDefinition = "TEXT" , name ="seguimento_empresa")
    private String seguimentoEmpresa;

    @Column(columnDefinition = "TEXT" , name ="desc_seguimento")
    private String descSeguimentoEmpresa;

    @Column(columnDefinition = "TEXT" , name ="endereco_empresa")
    private String enderecoEmpresa;

    @Column(columnDefinition = "TEXT" , name ="numero_end_empresa")
    private String numeroEmpresa;

    @Column(columnDefinition = "TEXT" ,  name ="complemento_end_empresa")
    private String complementoEmpresa;

    @Column(columnDefinition = "TEXT" ,  name ="bairro_empresa")
    private String bairroEmpresa;
    @Column(columnDefinition = "TEXT" ,  name ="cidade_empresa")
    private String cidadeEmpresa;

    @Column(columnDefinition = "TEXT" ,  name ="estado_empresa")
    private String estadoEmpresa;

    @OneToMany(mappedBy = "empresa",  cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vaga> vaga = new HashSet<>();

    public Empresa () {
        super();
    }

    public Empresa(int idEmpresa, String razaoSocialEmpresa, String nomeFantasiaEmpresa, String cnpjEmpresa,
                   String telefoneEmpresa, String emailEmpresa, String senhaEmpresa, String seguimentoEmpresa,
                   String descSeguimentoEmpresa, String enderecoEmpresa, String numeroEmpresa, String complementoEmpresa,
                   String bairroEmpresa, String cidadeEmpresa, String estadoEmpresa) {
        super();
        this.idEmpresa = idEmpresa;
        this.razaoSocialEmpresa = razaoSocialEmpresa;
        this.nomeFantasiaEmpresa = nomeFantasiaEmpresa;
        this.cnpjEmpresa = cnpjEmpresa;
        this.telefoneEmpresa = telefoneEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.senhaEmpresa = senhaEmpresa;
        this.seguimentoEmpresa = seguimentoEmpresa;
        this.descSeguimentoEmpresa = descSeguimentoEmpresa;
        this.enderecoEmpresa = enderecoEmpresa;
        this.numeroEmpresa = numeroEmpresa;
        this.complementoEmpresa = complementoEmpresa;
        this.bairroEmpresa = bairroEmpresa;
        this.cidadeEmpresa = cidadeEmpresa;
        this.estadoEmpresa = estadoEmpresa;
    }

    public int getId() {
        return idEmpresa;
    }

    public void setId(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocialEmpresa() {
        return razaoSocialEmpresa;
    }

    public void setRazaoSocialEmpresa(String razaoSocialEmpresa) {
        this.razaoSocialEmpresa = razaoSocialEmpresa;
    }

    public String getNomeFantasiaEmpresa() {
        return nomeFantasiaEmpresa;
    }

    public void setNomeFantasiaEmpresa(String nomeFantasiaEmpresa) {
        this.nomeFantasiaEmpresa = nomeFantasiaEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getTelefoneEmpresa() {
        return telefoneEmpresa;
    }

    public void setTelefoneEmpresa(String telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }

    public String getEmail() {
        return emailEmpresa;
    }

    public void setEmail(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getSenha() {
        return senhaEmpresa;
    }

    public void setSenha(String senhaEmpresa) {
        this.senhaEmpresa = senhaEmpresa;
    }

    public String getSeguimentoEmpresa() {
        return seguimentoEmpresa;
    }

    public void setSeguimentoEmpresa(String seguimentoEmpresa) {
        this.seguimentoEmpresa = seguimentoEmpresa;
    }

    public String getDescSeguimentoEmpresa() {
        return descSeguimentoEmpresa;
    }

    public void setDescSeguimentoEmpresa(String descSeguimentoEmpresa) {
        this.descSeguimentoEmpresa = descSeguimentoEmpresa;
    }

    public String getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(String enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public String getNumeroEmpresa() {
        return numeroEmpresa;
    }

    public void setNumeroEmpresa(String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }

    public String getComplementoEmpresa() {
        return complementoEmpresa;
    }

    public void setComplementoEmpresa(String complementoEmpresa) {
        this.complementoEmpresa = complementoEmpresa;
    }

    public String getBairroEmpresa() {
        return bairroEmpresa;
    }

    public void setBairroEmpresa(String bairroEmpresa) {
        this.bairroEmpresa = bairroEmpresa;
    }

    public String getCidadeEmpresa() {
        return cidadeEmpresa;
    }

    public void setCidadeEmpresa(String cidadeEmpresa) {
        this.cidadeEmpresa = cidadeEmpresa;
    }

    public String getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(String estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }




}
