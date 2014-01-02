
package fr.miage.orleans.modele.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Entity
public class SystemeCentral implements Serializable {
    
    public static final String CONTEXTE_WS = "/systemerue";
    
    @Id
    @GeneratedValue
    private int id;
    
    private String nom;
    
    private String protocole;
    
    private String adresse;
    
    private int port;
    
    private String contexte;
    
    private String authKey;
    
    private boolean selectionne;

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

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 29 * hash + this.id;
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final SystemeCentral other = (SystemeCentral) obj;
	return this.id == other.id;
    }
    
    
}
