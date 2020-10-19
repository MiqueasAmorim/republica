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
public enum TipoPeriodicidade {
    UNICA("Única"),
    SEMANAL("Semanal"),
    MENSAL("Mensal");
    
    private final String descricao;

    private TipoPeriodicidade(String descricao) {
        this.descricao = descricao;
    }
    
}
