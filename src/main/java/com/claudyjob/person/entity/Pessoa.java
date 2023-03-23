package com.claudyjob.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "tb_cadastro")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(nullable = false, length = 50)
    private String profissao;
    
    @Column(nullable = false, length = 255)
    private String dataNasc;

    public Pessoa() {
        
    }

    public Pessoa(Long id, String nome, String telefone, String profissao, String dataNasc) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.profissao = profissao;
        this.dataNasc = dataNasc;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id 
                        + ", nome=" + nome 
                        + ", telefone=" + telefone 
                        + ", profissao=" + profissao
                        + ", dataNasc=" + dataNasc + "]";
    }

    public boolean isEmpty() {
        return false;
    }

   
}