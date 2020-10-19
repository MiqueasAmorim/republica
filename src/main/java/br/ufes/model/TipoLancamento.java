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
public enum TipoLancamento {
   RECEITA("Receita"), 
   DESPESA("Despesa");
   
   private final String descricao;
   
   TipoLancamento(String descricao) {
    this.descricao = descricao;   
   }
   
}
