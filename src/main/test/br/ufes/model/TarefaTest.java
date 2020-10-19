package br.ufes.model;

import factory.MoradorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TarefaTest {

    private static MoradorFactory moradorFactory;
    @BeforeAll
    public static void setMoradorFactory() {
        moradorFactory = new MoradorFactory();
    }

    /**
     * BR 08 - Tarefas:
     * Finalizada: será marcado como concluído quando a tarefa for realizada pelo(s) morador(es) que ficou(ficaram)
     * responsável(is) pela mesma.
     */
    @Test
    public void CT012() {
        Morador responsavel = moradorFactory.create();

        ArrayList<Morador> responsaveis = new ArrayList<>();
        responsaveis.add(responsavel);

        Tarefa tarefa = new Tarefa(
                "Teste",
                LocalDate.now(),
                LocalDate.now().plusDays(2),
                responsaveis
        );

        tarefa.finalizarTarefa();

        assertTrue(tarefa.isFinalizada());
    }

    /**
     * BR 08 - Tarefas:
     * Finalizada: a data de conclusão não deve ser nula quando a tarefa é finalizada
     */
    @Test
    public void CT013() {
        Morador responsavel = moradorFactory.create();

        ArrayList<Morador> responsaveis = new ArrayList<>();
        responsaveis.add(responsavel);

        Tarefa tarefa = new Tarefa(
                "Teste",
                LocalDate.now(),
                LocalDate.now().plusDays(2),
                responsaveis
        );

        tarefa.finalizarTarefa();

        assertNotNull(tarefa.getDataRealizacao());
    }


    /**
     * BR 08 - Tarefas
     * A data de término de uma tarefa não deve ser menor que a data de lançamento
     */
    @Test
    public void CT014() {
        Morador responsavel = moradorFactory.create();

        ArrayList<Morador> responsaveis = new ArrayList<>();
        responsaveis.add(responsavel);

        assertThrows(Exception.class, () -> {
            new Tarefa(
                    "Teste",
                    LocalDate.now(),
                    LocalDate.now().minusDays(1),
                    responsaveis
            );
        });

    }


}