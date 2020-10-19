package factory;

import br.ufes.model.Geolocalizacao;

public class GeolocalizacaoFactory {

    private double latitude = 123456d;
    private double longitude = 654321d;

    public GeolocalizacaoFactory(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeolocalizacaoFactory() {
    }

    public Geolocalizacao create() {
        return new Geolocalizacao(this.latitude, this.longitude);
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
