package br.ufes.model;

import br.ufes.model.Morador;
import br.ufes.model.Republica;
import factory.MoradorFactory;
import factory.RepublicaFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoradorTest {

    private static MoradorFactory moradorFactory;
    private static RepublicaFactory republicaFactory;
    @BeforeAll
    public static void setMoradorFactory() {
        moradorFactory = new MoradorFactory();
        republicaFactory = new RepublicaFactory();
    }


    /**
     * BR 2.0 - O morador pode criar sua república,
     * e ao fazer isso ele precisa ser informado que caso confirme a criação de uma nova república,
     * deixará a república atual.
     */
    @Test
    public void CT001() throws Exception {
        Morador morador = moradorFactory.create();
        Republica republicaAntiga = morador.getRepublicaAtual();

        Republica novaRepublica = republicaFactory.create();

        morador.criarRepublica(novaRepublica);
        assertEquals(republicaAntiga.getMoradores().size(), 0);
    }

    /**
     * BR 2.0 - O morador pode criar sua república, e ao fazer isso se tornará o representante da nova república
     */
    @Test
    public void CT002() throws Exception {
        Morador morador = moradorFactory.create();

        Republica novaRepublica = republicaFactory.create();

        morador.criarRepublica(novaRepublica);
        assertEquals(novaRepublica.getRepresentante(), morador);
    }



    /**
     * BR 2.2 - A reputação de um Morador deve ser o somatório dos índices ISR, IRT e ICP
     */
    @Test
    public void CT003() {
        Morador morador = moradorFactory.create();
        morador.setTotalReclamacoesMensal(5);
        morador.setTotalReclamacoesResolvidasMensal(5);
        morador.setTotalTarefasMensal(5);
        morador.setTotalTarefasConcluidasMensal(3);
        morador.setDiaVencimentoPagamentoContasMensal(10);
        morador.setDiaPagamentoContasMensal(12);

        assertEquals(2.43d, morador.getReputacaoMensal(), 0.01);

    }

    /**
     * BR 2.2 - A reputação de um Morador deve ser o somatório dos índices ISR, IRT e ICP
     */
    @Test
    public void CT004() {
        Morador morador = moradorFactory.create();
        morador.setTotalReclamacoesMensal(4);
        morador.setTotalReclamacoesResolvidasMensal(0);
        morador.setTotalTarefasMensal(3);
        morador.setTotalTarefasConcluidasMensal(1);
        morador.setDiaVencimentoPagamentoContasMensal(10);
        morador.setDiaPagamentoContasMensal(16);

        assertEquals(0.96d, morador.getReputacaoMensal(), 0.01);

    }

    /**
     * BR 2.2 - A reputação de um Morador deve ser o somatório dos índices ISR, IRT e ICP
     */
    @Test
    public void CT005() {
        Morador morador = moradorFactory.create();
        morador.setTotalReclamacoesMensal(4);
        morador.setTotalReclamacoesResolvidasMensal(4);
        morador.setTotalTarefasMensal(6);
        morador.setTotalTarefasConcluidasMensal(6);
        morador.setDiaVencimentoPagamentoContasMensal(10);
        morador.setDiaPagamentoContasMensal(9);

        assertEquals(3.11d, morador.getReputacaoMensal(), 0.01);
    }

    /**
     * BR 2.2 - A reputação de um Morador deve ser o somatório dos índices ISR, IRT e ICP
     */
    @Test
    public void CT006() {
        Morador morador = moradorFactory.create();
        morador.setTotalReclamacoesMensal(0);
        morador.setTotalReclamacoesResolvidasMensal(0);
        morador.setTotalTarefasMensal(1);
        morador.setTotalTarefasConcluidasMensal(2);
        morador.setDiaVencimentoPagamentoContasMensal(10);
        morador.setDiaPagamentoContasMensal(2);

        assertEquals(7.00d, morador.getReputacaoMensal(), 0.01);
    }


}