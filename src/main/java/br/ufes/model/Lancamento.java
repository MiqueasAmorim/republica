/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Miqueas
 */
public class Lancamento {
    private TipoLancamento tipo;
    private String descricao;
    private LocalDate dataVencimento;
    private double valor; 
    private TipoPeriodicidade periodicidade;
    private double valorParcela;
    private ArrayList<Morador> moradoresParticipantes;

    public Lancamento(TipoLancamento tipo, String descricao, LocalDate dataVencimento, double valor, TipoPeriodicidade periodicidade, double valorParcela) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.periodicidade = periodicidade;
        this.valorParcela = valorParcela;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public TipoPeriodicidade getPeriodicidade() {
        return periodicidade;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public ArrayList<Morador> getMoradoresParticipantes() {
        return moradoresParticipantes;
    }

    @Override
    public String toString() {
        return "Lancamento{" + "tipo=" + tipo + ", descricao=" + descricao + ", dataVencimento=" + dataVencimento + ", valor=" + valor + ", periodicidade=" + periodicidade + ", valorParcela=" + valorParcela + ", moradoresParticipantes=" + moradoresParticipantes + '}';
    }
    
}
