package factory;

import br.ufes.model.Endereco;

public class EnderecoFactory {
    private String logradouro = "Rua ABC da silva";
    private Integer numero = 12;
    private String CEP = "29500000";
    private String bairro = "Centro";
    private String pontoReferencia = "Subida do Morro da Ufes";
    private GeolocalizacaoFactory geolocalizacaoFactory = new GeolocalizacaoFactory();

    public void setGeolocalizacaoFactory(GeolocalizacaoFactory geolocalizacaoFactory) {
        this.geolocalizacaoFactory = geolocalizacaoFactory;
    }

    public EnderecoFactory(String logradouro, Integer numero, String CEP, String bairro, String pontoReferencia, GeolocalizacaoFactory geolocalizacaoFactory) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.CEP = CEP;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.geolocalizacaoFactory = geolocalizacaoFactory;
    }

    public EnderecoFactory() {

    }

    public Endereco create() {
        return new Endereco(
                logradouro,
                numero,
                CEP,
                bairro,
                this.geolocalizacaoFactory.create(),
                pontoReferencia
        );
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }
}
