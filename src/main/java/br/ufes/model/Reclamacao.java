/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Miqueas
 */
public class Reclamacao {
    private String descricao;
    private LocalDate data;
    private Morador moradorQueReportou;
    private Date dataSolucao;
    private boolean excluida;

    public Reclamacao(String descricao, LocalDate data, Morador morador) {
        this.descricao = descricao;
        this.data = data;
        this.moradorQueReportou = morador;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public Morador getMorador() {
        return moradorQueReportou;
    }

    public Date getDataSolucao() {
        return dataSolucao;
    }

    public boolean isExcluida() {
        return excluida;
    }
    
    public void solucionar() {
        this.dataSolucao = new Date();
    }
    
    public void excluir() {
        this.excluida = true;
    }

    @Override
    public String toString() {
        return "Reclamacao{" + "descricao=" + descricao + ", data=" + data + ", moradorQueReportou=" + moradorQueReportou + ", dataSolucao=" + dataSolucao + ", excluida=" + excluida + '}';
    }
    
}
