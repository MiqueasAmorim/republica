package br.ufes.model;

import br.ufes.model.Morador;
import br.ufes.model.Republica;
import factory.EnderecoFactory;
import factory.MoradorFactory;
import factory.RepublicaFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RepublicaTest {

    private static MoradorFactory moradorFactory;
    private static RepublicaFactory republicaFactory;
    private static EnderecoFactory enderecoFactory;
    @BeforeAll
    public static void setMoradorFactory() {
        moradorFactory = new MoradorFactory();
        republicaFactory = new RepublicaFactory();
        enderecoFactory = new EnderecoFactory();
    }

    /**
     * BR 07 - Vagas de uma república - Não deve ser possível existir 0 vagas
     */
    @Test
    public void CT007() {
        assertThrows(RuntimeException.class, () -> {
            Republica republica = new Republica(
                    "Nome",
                    LocalDate.now(),
                    null,
                    enderecoFactory.create(),
                    "Salgadinho de graça",
                    0
            );
        });
    }


    /**
     * BR 07 - Vagas de uma república - Não deve ser possível existir vagas negativas
     */
    @Test
    public void CT008() {
        assertThrows(RuntimeException.class, () -> {
            Republica republica = new Republica(
                    "Nome",
                    LocalDate.now(),
                    null,
                    enderecoFactory.create(),
                    "Salgadinho de graça",
                    -1
            );
        });
    }

    /**
     * BR 07 - Vagas disponíveis é o número de vagas totais - número de pessoas na república
     */
    @Test
    public void CT009() throws Exception {
        Republica republica = republicaFactory.create(3);

        republica.adicionarMorador(moradorFactory.create());
        republica.adicionarMorador(moradorFactory.create());

        assertEquals(republica.getVagas(), 1);
    }

    /**
     * BR 07 - Não deve ser possível adicionar pessoas além do número de vagas
     */
    @Test
    public void CT010() throws Exception {
        Republica republica = republicaFactory.create(1);

        republica.adicionarMorador(moradorFactory.create());

        Exception exception = assertThrows(Exception.class, () -> {
            republica.adicionarMorador(moradorFactory.create());
        });

        assertEquals("Não há vaga disponível", exception.getMessage());
    }

    /**
     * BR 07 - Não deve ser possível remover pessoas quando não há ninguém
     */
    @Test
    public void CT011() throws Exception {
        Republica republica = republicaFactory.create(1);

        Morador morador = moradorFactory.create();

        republica.adicionarMorador(morador);
        republica.removerMorador(morador);

        Exception exception = assertThrows(Exception.class, () -> {
            republica.removerMorador(morador);
        });

        assertEquals("O morador não pertence a essa república", exception.getMessage());
    }

    /**
     * Verifica que não é possível criar uma República com data de extinção igual à data de criação
     */
    @Test
    public void CT012() {
        Endereco endereco = enderecoFactory.create();

        LocalDate data = LocalDate.now();

        assertThrows(Exception.class, () -> {
            new Republica(
                    "Nome",
                    data,
                    data,
                    endereco,
                    "nenhuma",
                    1
            );
        });
    }

    /**
     * Verifica que não é possível criar uma República com data de extinção menor à data de criação
     */
    @Test
    public void CT013() {
        Endereco endereco = enderecoFactory.create();

        LocalDate data = LocalDate.now();

        assertThrows(Exception.class, () -> {
            new Republica(
                    "Nome",
                    data,
                    data.minusDays(1),
                    endereco,
                    "nenhuma",
                    1
            );
        });
    }

    @Test
    public void CT019() {
        assertThrows(Exception.class, () -> {
            new Republica(
                    "Nome da Republica",
                    LocalDate.now(),
                    null,
                    null,
                    "vantagem 1",
                    1
            );
        });
    }


}