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
public class Tarefa {

    private String descricao;
    private LocalDate dataAgendamento;
    private LocalDate dataTermino;
    private ArrayList<Morador> moradoresResponsaveis;
    private LocalDate dataRealizacao;
    private boolean finalizada;

    public Tarefa(String descricao, LocalDate dataAgendamento, LocalDate dataTermino, ArrayList<Morador> moradoresResponsaveis) {
        this.descricao = descricao;
        this.dataAgendamento = dataAgendamento;
        this.dataTermino = dataTermino;
        this.moradoresResponsaveis = new ArrayList<>();
        this.moradoresResponsaveis.addAll(moradoresResponsaveis);
        this.finalizada = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public ArrayList<Morador> getMoradoresResponsaveis() {
        return moradoresResponsaveis;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public boolean isFinalizada() {
        return finalizada;
    }
    
    public void finalizarTarefa() {
        this.finalizada = true;
        this.dataRealizacao = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Tarefa{" + "descricao=" + descricao + ", dataAgendamento=" + dataAgendamento + ", dataTermino=" + dataTermino + ", moradoresResponsaveis=" + moradoresResponsaveis + ", dataRealizacao=" + dataRealizacao + ", finalizada=" + finalizada + '}';
    }

}
