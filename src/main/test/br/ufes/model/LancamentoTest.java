package br.ufes.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LancamentoTest {

    /**
     * Não deve ser possível realizar um lançamento com valor 0
     */
    @Test
    public void CT015() {
        assertThrows(Exception.class, () -> {
            new Lancamento(
                    TipoLancamento.DESPESA,
                    "Despesa Teste",
                    LocalDate.now(),
                    0,
                    TipoPeriodicidade.MENSAL,
                    0
            );
        });
    }

    /**
     * Não deve ser possível realizar um lançamento com valor de parcela maior que o valor total
     */
    @Test
    public void CT016() {
        assertThrows(Exception.class, () -> {
            new Lancamento(
                    TipoLancamento.DESPESA,
                    "Despesa Teste",
                    LocalDate.now(),
                    100,
                    TipoPeriodicidade.MENSAL,
                    1000
            );
        });
    }

}