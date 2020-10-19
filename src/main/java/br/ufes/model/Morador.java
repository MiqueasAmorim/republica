/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.util.ArrayList;

/**
 *
 * @author Miqueas
 */
public class Morador {

    private String nome;
    private String apelido;
    private String telefone;
    private ArrayList<String> linksRedesSociais;
    private ArrayList<String> telefonesContatos;
    private ArrayList<Republica> historicoRepublicas;
    private Republica republicaAtual;

    private int totalReclamacoesMensal;
    private int totalReclamacoesResolvidasMensal;

    private int totalTarefasMensal;
    private int totalTarefasConcluidasMensal;

    private int diaVencimentoPagamentoContasMensal;
    private int diaPagamentoContasMensal;

    public Morador(String nome, String apelido, String telefone, String telefoneContato1, String telefoneContato2, Republica republicaAtual) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.republicaAtual = republicaAtual;
        this.telefonesContatos = new ArrayList<>();
        this.telefonesContatos.add(telefoneContato1);
        this.telefonesContatos.add(telefoneContato2);
        this.historicoRepublicas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public ArrayList<String> getLinksRedesSociais() {
        return linksRedesSociais;
    }

    public ArrayList<String> getTelefonesContatos() {
        return telefonesContatos;
    }

    public ArrayList<Republica> getHistoricoRepublicas() {
        return historicoRepublicas;
    }

    public Republica getRepublicaAtual() {
        return republicaAtual;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setRepublicaAtual(Republica republicaAtual) {
        this.republicaAtual = republicaAtual;
    }

    public void criarRepublica(Republica novaRepublica) throws Exception {
        if (this.republicaAtual != null) {
            this.republicaAtual.removerMorador(this);
        }
        novaRepublica.adicionarMorador(this);
        novaRepublica.setRepresentante(this);
        this.setRepublicaAtual(novaRepublica);
    }

    public int getTotalReclamacoesMensal() {
        return totalReclamacoesMensal;
    }

    public int getTotalReclamacoesResolvidasMensal() {
        return totalReclamacoesResolvidasMensal;
    }

    public int getTotalTarefasMensal() {
        return totalTarefasMensal;
    }

    public int getTotalTarefasConcluidasMensal() {
        return totalTarefasConcluidasMensal;
    }

    public int getDiaVencimentoPagamentoContasMensal() {
        return diaVencimentoPagamentoContasMensal;
    }

    public int getDiaPagamentoContasMensal() {
        return diaPagamentoContasMensal;
    }
    
    public double getReputacaoMensal() {
        return calcularIndiceSolucaoReclamacoesMensal()
                + calcularIndiceRealizacaoTarefasMensal()
                + calcularIndiceCompromissoPagamentos();
    }

    private double calcularIndiceSolucaoReclamacoesMensal() {
        return this.totalReclamacoesResolvidasMensal / this.totalReclamacoesMensal;
    }

    private double calcularIndiceRealizacaoTarefasMensal() {
        return this.totalTarefasConcluidasMensal / this.totalTarefasMensal;
    }

    private double calcularIndiceCompromissoPagamentos() {
        return this.diaVencimentoPagamentoContasMensal / this.diaPagamentoContasMensal;
    }

    @Override
    public String toString() {
        return "Morador{" + "nome=" + nome + ", apelido=" + apelido + ", telefone=" + telefone + ", telefonesContatos=" + telefonesContatos + '}';
    }

    public void setTotalReclamacoesMensal(int totalReclamacoesMensal) {
        this.totalReclamacoesMensal = totalReclamacoesMensal;
    }

    public void setTotalReclamacoesResolvidasMensal(int totalReclamacoesResolvidasMensal) {
        this.totalReclamacoesResolvidasMensal = totalReclamacoesResolvidasMensal;
    }

    public void setTotalTarefasMensal(int totalTarefasMensal) {
        this.totalTarefasMensal = totalTarefasMensal;
    }

    public void setTotalTarefasConcluidasMensal(int totalTarefasConcluidasMensal) {
        this.totalTarefasConcluidasMensal = totalTarefasConcluidasMensal;
    }

    public void setDiaVencimentoPagamentoContasMensal(int diaVencimentoPagamentoContasMensal) {
        this.diaVencimentoPagamentoContasMensal = diaVencimentoPagamentoContasMensal;
    }

    public void setDiaPagamentoContasMensal(int diaPagamentoContasMensal) {
        this.diaPagamentoContasMensal = diaPagamentoContasMensal;
    }
}
