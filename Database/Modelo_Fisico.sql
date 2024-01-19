CREATE DATABASE nova_database;

USE nova_database;

CREATE TABLE candidato (
    id_candidato INTEGER auto_increment PRIMARY KEY,
    nome_candidato VARCHAR (255) not null,
    cpf_candidato VARCHAR (11) unique not null,
    telefone_candidato VARCHAR (15) not null,
	email_candidato VARCHAR (255) unique not null,
    senha_candidato VARCHAR (10) not null,
    tipo_deficiencia VARCHAR (255) not null,
    desc_deficiencia VARCHAR (255) ,    
    formacao_academica VARCHAR (255) not null,
	endereco_candidato VARCHAR (255) not null,
    numero_end_candidato VARCHAR (255) not null,
    complemento_end_candidato VARCHAR (255),
    bairro_candidato VARCHAR (255) not null,
    cidade_candidato VARCHAR (255) not null,
	estado_candidato VARCHAR (255) not null
);

CREATE TABLE empresa (
    id_empresa INTEGER auto_increment PRIMARY KEY,
    razao_social VARCHAR (255) not null,
    nome_fantasia VARCHAR (255) not null,
    cnpj VARCHAR (14) unique not null,
    telefone_empresa VARCHAR (255) not null,    
    email_empresa VARCHAR (255) unique not null,
    senha_empresa VARCHAR (10) not null,    
    seguimento_empresa VARCHAR (255) not null,
    desc_seguimento VARCHAR (255),
    endereco_empresa VARCHAR (255) not null,
    numero_end_empresa VARCHAR (255) not null,
    complemento_end_empresa VARCHAR (255) ,
    bairro_empresa VARCHAR (255) not null,
    cidade_empresa VARCHAR (255) not null,
    estado_empresa VARCHAR (255) not null
);

CREATE TABLE contato (
    id_contato INTEGER auto_increment PRIMARY KEY,
    nome_contato VARCHAR (255) not null,
    email_contato VARCHAR (255) not null,
    assunto_contato VARCHAR (255) not null,
    mensagem_contato VARCHAR (255) not null
);

CREATE TABLE vaga (
    id_vaga INTEGER auto_increment PRIMARY KEY,
    cod_vaga INTEGER not null,
    nome_vaga VARCHAR (255) not null,
    desc_vaga VARCHAR (255) not null,
    id_empresa INTEGER  
);

CREATE TABLE candidatura (
	id_candidatura INTEGER auto_increment PRIMARY KEY,
    id_vaga INTEGER ,
    id_candidato INTEGER ,
    status_candidatura VARCHAR (255)    
);