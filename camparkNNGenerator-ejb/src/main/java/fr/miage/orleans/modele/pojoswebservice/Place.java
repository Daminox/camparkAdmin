
package fr.miage.orleans.modele.pojoswebservice;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public class Place implements PojoWebService{
    
    private long numero;
    
    private double latitude;
    
    private double longitude;
    
    private boolean libre;

    @Override
    public String getIdToString() {
	return Long.toString(this.numero);
    }

    public long getNumero() {
	return numero;
    }

    public void setNumero(long numero) {
	this.numero = numero;
    }

    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }

    public boolean isLibre() {
	return libre;
    }

    public void setLibre(boolean libre) {
	this.libre = libre;
    }
}
