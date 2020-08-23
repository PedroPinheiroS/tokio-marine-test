package com.example.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "address")
@Table(name = "address")
public class Address {

    @JsonIgnore
    @Id
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    Customer id_customer;

    @Column
    String cep;

    @Column
    String logradouro;

    @Column
    String complemento;

    @Column
    String bairro;

    @Column
    String localidade;

    @Column
    String uf;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setId_customer(Customer id_customer) {
        this.id_customer = id_customer;
    }
}
