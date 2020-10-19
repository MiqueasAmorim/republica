/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Miqueas
 */
public class Main {
    public static void main(String[] args) throws Exception {
                
        Republica republica = new Republica("Xerebebeu", LocalDate.now(), null,
        new Endereco("Rua do Milho", 455, "29550-000", "Alto Universitário", new Geolocalizacao(44.66, 77.66), null), null, 4);
        Morador morador1 = new Morador("Pedro Júnior", "Juninho", "28999448899", "28999554411", "28999446622", null);
        republica.adicionarMorador(morador1);
        republica.setRepresentante(morador1);
        Morador morador2 = new Morador("João Carlos", "BG", "28999448899", "28999554411", "28999446622", null);
        republica.adicionarMorador(morador2);
        republica.adicionarMorador(new Morador("Guilherme", null, "28999448899", "28999554411", "28999446622", null));
        republica.adicionarMorador(new Morador("Soares", "Soares", "28999448899", "28999554411", "28999446622", null));
        republica.removerMorador(morador2);
        republica.adicionarMorador(new Morador("Socrátes", "Filósofo", "28999448899", "28999554411", "28999446622", null));
        
        Lancamento contaAgua = new Lancamento(TipoLancamento.DESPESA, "Conta de água", LocalDate.of(2020, Month.NOVEMBER, 5), 56.45, TipoPeriodicidade.UNICA, 0);
        Lancamento contaLuz = new Lancamento(TipoLancamento.DESPESA, "Conta de luz", LocalDate.of(2020, Month.OCTOBER, 7), 150.78, TipoPeriodicidade.UNICA, 0);
        Lancamento netflix = new Lancamento(TipoLancamento.DESPESA, "Netflix", LocalDate.of(2020, Month.OCTOBER, 20), 48.00, TipoPeriodicidade.MENSAL, 0);
        
        
        Lancamento doacao = new Lancamento(TipoLancamento.RECEITA, "Doação do João", LocalDate.of(2020, Month.OCTOBER, 20), 30.00, TipoPeriodicidade.UNICA, 0);
        
        republica.registrarLancamento(contaAgua);
        republica.registrarLancamento(doacao);
        republica.registrarLancamento(contaLuz);
        republica.registrarLancamento(netflix);
        
        republica.registrarTarefa(new Tarefa("Limpar a casa", LocalDate.now(), LocalDate.of(2020, Month.OCTOBER, 21), new ArrayList<Morador>(republica.getMoradores())));
        republica.registrarReclamacao(new Reclamacao("Louças sujas desde a noite passada", LocalDate.now(), null));
        
        
        System.out.println("Despesas: " + republica.getDespesas());
        System.out.println("Receitas: " + republica.getReceitas());
        System.out.println("Receita coletiva: " + republica.getReceitaColetiva());
        System.out.println("Reclamações: " + republica.getReclamacoes());
        System.out.println("Tarefas: " + republica.getTarefas());
        // System.out.println("República criada: " + republica);
    }
}
