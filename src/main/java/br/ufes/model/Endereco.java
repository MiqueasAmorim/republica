/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

/**
 *
 * @author Miqueas
 */
public class Endereco {
    private String logradouro;
    private Integer numero;
    private String CEP;
    private String bairro;
    private Geolocalizacao geolocalizacao;
    private String pontoReferencia;

    public Endereco(String logradouro, Integer numero, String CEP, String bairro, Geolocalizacao geolocalizacao, String pontoReferencia) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.CEP = CEP;
        this.bairro = bairro;
        this.geolocalizacao = geolocalizacao;
        this.pontoReferencia = pontoReferencia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getCEP() {
        return CEP;
    }

    public String getBairro() {
        return bairro;
    }

    public Geolocalizacao getGeolocalizacao() {
        return geolocalizacao;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

}
