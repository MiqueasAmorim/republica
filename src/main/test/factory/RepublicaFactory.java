package factory;

import br.ufes.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class RepublicaFactory {
    private String nome = "Xerebebeu";
    private LocalDate dataFundacao = LocalDate.now();
    private LocalDate dataExtincao = null;
    private String vantagens = "nenhuma";
    private Integer vagas = 10;
    private EnderecoFactory enderecoFactory = new EnderecoFactory();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setDataExtincao(LocalDate dataExtincao) {
        this.dataExtincao = dataExtincao;
    }

    public void setVantagens(String vantagens) {
        this.vantagens = vantagens;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void setEnderecoFactory(EnderecoFactory enderecoFactory) {
        this.enderecoFactory = enderecoFactory;
    }



    public Republica create(Endereco endereco) {
        return new Republica(
                nome,
                dataFundacao,
                dataExtincao,
                endereco,
                vantagens,
                vagas
        );
    }

    public Republica create() {
        return new Republica(
                nome,
                dataFundacao,
                dataExtincao,
                this.enderecoFactory.create(),
                vantagens,
                vagas
        );
    }

    public Republica create(Integer vagas) {
        return new Republica(
                nome,
                dataFundacao,
                dataExtincao,
                this.enderecoFactory.create(),
                vantagens,
                vagas
        );
    }

}
