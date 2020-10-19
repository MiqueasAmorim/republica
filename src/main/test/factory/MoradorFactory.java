package factory;

import br.ufes.model.Morador;
import br.ufes.model.Republica;

import java.util.ArrayList;
import java.util.Arrays;

public class MoradorFactory {
    private String nome = "Fulano da Silva";
    private String apelido = "Fulaninho";
    private String telefone = "7070-7070";
    private ArrayList<String> linksRedesSociais = new ArrayList<>();
    private ArrayList<String> telefonesContatos = new ArrayList<>(Arrays.asList("35532509", "35526025"));
    private RepublicaFactory republicaFactory = new RepublicaFactory();

    public MoradorFactory(String nome, String apelido, String telefone, ArrayList<String> linksRedesSociais, ArrayList<String> telefonesContatos, RepublicaFactory republicaFactory) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.linksRedesSociais = linksRedesSociais;
        this.telefonesContatos = telefonesContatos;
        this.republicaFactory = republicaFactory;
    }

    public MoradorFactory() {
    }

    public Morador create() {
        return new Morador(
                nome,
                apelido,
                telefone,
                telefonesContatos.get(0),
                telefonesContatos.get(1),
                this.republicaFactory.create()
        );
    }

    public Morador create(Republica republica) {
        return new Morador(
                nome,
                apelido,
                telefone,
                telefonesContatos.get(0),
                telefonesContatos.get(1),
                republica
        );
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

    public void setLinksRedesSociais(ArrayList<String> linksRedesSociais) {
        this.linksRedesSociais = linksRedesSociais;
    }

    public void setTelefonesContatos(ArrayList<String> telefonesContatos) {
        this.telefonesContatos = telefonesContatos;
    }

    public void setRepublicaFactory(RepublicaFactory republicaFactory) {
        this.republicaFactory = republicaFactory;
    }
}
