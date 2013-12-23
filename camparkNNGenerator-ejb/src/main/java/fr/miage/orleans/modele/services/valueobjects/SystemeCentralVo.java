
package fr.miage.orleans.modele.services.valueobjects;

import fr.miage.orleans.modele.entities.SystemeCentral;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public class SystemeCentralVo {
    private int id;
    
    private String nom;
    
    private String protocole;
    
    private String adresse;
    
    private int port;
    
    private String contexte;
    
    private String authKey;
    
    private boolean selectionne;
    
    private String urlComplete;
    
    public SystemeCentralVo() {
	
    }
    
    public SystemeCentralVo(SystemeCentral systemeCentral) {
	this.id = systemeCentral.getId();
	this.nom = systemeCentral.getNom();
	this.protocole = systemeCentral.getProtocole();
	this.adresse = systemeCentral.getAdresse();
	this.port = systemeCentral.getPort();
	this.contexte = systemeCentral.getContexte();
	this.authKey = systemeCentral.getAuthKey();
	this.selectionne = systemeCentral.isSelectionne();
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append(this.protocole).append("://").append(this.adresse).append(':').append(this.port).append('/').append(this.contexte).append(SystemeCentral.CONTEXTE_WS);
	this.urlComplete = stringBuilder.toString();
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getProtocole() {
	return protocole;
    }

    public void setProtocole(String protocole) {
	this.protocole = protocole;
    }

    public String getAdresse() {
	return adresse;
    }

    public void setAdresse(String adresse) {
	this.adresse = adresse;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public String getContexte() {
	return contexte;
    }

    public void setContexte(String contexte) {
	this.contexte = contexte;
    }

    public String getAuthKey() {
	return authKey;
    }

    public void setAuthKey(String authKey) {
	this.authKey = authKey;
    }

    public boolean isSelectionne() {
	return selectionne;
    }

    public void setSelectionne(boolean selectionne) {
	this.selectionne = selectionne;
    }

    public String getUrlComplete() {
	return urlComplete;
    }

    public void setUrlComplete(String urlComplete) {
	this.urlComplete = urlComplete;
    }
    
    
}
