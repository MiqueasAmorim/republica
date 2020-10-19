package br.ufes.model;

import factory.MoradorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReclamacaoTest {
    private static MoradorFactory moradorFactory;

    @BeforeAll
    public static void setMoradorFactory() {
        moradorFactory = new MoradorFactory();
    }

    /**
     * BR 09 - Reclamações/Sugestões
     * Um sem-teto não pode criar uma reclamação
     */
    @Test
    public void CT017() {
        Morador moradorSemTeto = moradorFactory.create(null);

        assertThrows(Exception.class, () -> {
            new Reclamacao(
                    "Reclamação Teste",
                    LocalDate.now(),
                    moradorSemTeto
            );
        });

    }

    /**
     * BR 09 - Reclamações/Sugestões
     * Uma Reclamação deve conter a data na qual foi feita
     */
    @Test
    public void CT018() {
        Morador morador = moradorFactory.create();

        assertThrows(Exception.class, () -> {
            new Reclamacao(
                    "Reclamação Teste",
                    null,
                    morador
            );
        });

    }
}