/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Miqueas
 */
public class Republica {

    private String nome;
    private LocalDate dataFundacao;
    private LocalDate dataExtincao;
    private Endereco endereco;
    private String vantagens;
    private Double mediaDespesasPorMorador;
    private Integer vagas;
    private Integer prazoAvisoVencimentoEmDias = 5;
    private ArrayList<Morador> moradores;
    private Morador representante;
    private double receitaColetiva = 0;
    private Map<TipoLancamento, ArrayList<Lancamento>> lancamentos;
    private ArrayList<Tarefa> tarefas;
    private ArrayList<Reclamacao> reclamacoes;

    public Republica(String nome, LocalDate dataFundacao, LocalDate dataExtincao, Endereco endereco, String vantagens, Integer vagas) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.dataExtincao = dataExtincao;
        this.endereco = endereco;
        this.vantagens = vantagens;
        this.vagas = vagas;
        this.moradores = new ArrayList<>();
        this.lancamentos = new HashMap<>();
        this.tarefas = new ArrayList<>();
        this.reclamacoes = new ArrayList<>();
        this.lancamentos.put(TipoLancamento.RECEITA, new ArrayList<Lancamento>());
        this.lancamentos.put(TipoLancamento.DESPESA, new ArrayList<Lancamento>());
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public LocalDate getDataExtincao() {
        return dataExtincao;
    }
    
    public String getVantagens() {
        return vantagens;
    }

    public Double getMediaDespesasPorMorador() {
        return mediaDespesasPorMorador;
    }

    public Integer getVagas() {
        return vagas;
    }

    public double getReceitaColetiva() {
        return receitaColetiva;
    }

    public Integer getPrazoAvisoVencimentoEmDias() {
        return prazoAvisoVencimentoEmDias;
    }

    public ArrayList<Morador> getMoradores() {
        return moradores;
    }

    public Morador getRepresentante() {
        return representante;
    }

    public Map<TipoLancamento, ArrayList<Lancamento>> getLancamentos() {
        return lancamentos;
    }

    public ArrayList<Reclamacao> getReclamacoes() {
        return reclamacoes;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public ArrayList<Lancamento> getDespesas() {
        return this.lancamentos.get(TipoLancamento.DESPESA);
    }

    public ArrayList<Lancamento> getReceitas() {
        return this.lancamentos.get(TipoLancamento.RECEITA);
    }

    public void setPrazoAvisoVencimentoEmDias(Integer prazoAvisoVencimentoEmDias) {
        this.prazoAvisoVencimentoEmDias = prazoAvisoVencimentoEmDias;
    }

    public void setRepresentante(Morador representante) {
        this.representante = representante;
    }

    public void adicionarMorador(Morador morador) throws Exception {
        if (this.vagas == 0) {
            throw new Exception("Não há vaga disponível");
        }
        this.moradores.add(morador);
        this.vagas--;
    }

    public void removerMorador(Morador morador) throws Exception {
        if (!this.moradores.contains(morador)) {
            throw new Exception("O morador não pertence a essa república");
        }
        this.moradores.remove(morador);
        this.vagas++;
    }

    public void registrarLancamento(Lancamento lancamento) {
        if (lancamento.getTipo().equals(TipoLancamento.DESPESA)) {
            this.lancamentos.get(TipoLancamento.DESPESA).add(lancamento);
            return;
        }
        this.lancamentos.get(TipoLancamento.RECEITA).add(lancamento);
        this.receitaColetiva += lancamento.getValor();
    }
    
    public void registrarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public void registrarReclamacao(Reclamacao reclamacao) {
        this.reclamacoes.add(reclamacao);
    }

    @Override
    public String toString() {
        return "Republica{" + "nome=" + nome + ", dataFundacao=" + dataFundacao + ", dataExtincao=" + dataExtincao + ", endereco=" + endereco + ", vantagens=" + vantagens + ", mediaDespesasPorMorador=" + mediaDespesasPorMorador + ", vagas=" + vagas + ", prazoAvisoVencimentoEmDias=" + prazoAvisoVencimentoEmDias + ", moradores=" + moradores + ", representante=" + representante + ", receitaColetiva=" + receitaColetiva + ", lancamentos=" + lancamentos + ", tarefas=" + tarefas + ", reclamacoes=" + reclamacoes + '}';
    }

}
