
package fr.miage.orleans.modele.services.valueobjects;

import fr.miage.orleans.modele.entities.Camera;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public class CameraVoFluxPhotos {
    
    private String nomCamera;
    
    private int nbPlacesCamera;
    
    private int nbImagesCamera;
    
    public CameraVoFluxPhotos() {
	
    }
    
    public CameraVoFluxPhotos(Camera camera) {
	this.nomCamera = camera.getNomCamera();
	this.nbPlacesCamera = camera.getPlacesCamera().size();
	this.nbImagesCamera = camera.getImagesCamera().size();
    }

    public String getNomCamera() {
	return nomCamera;
    }

    public void setNomCamera(String nomCamera) {
	this.nomCamera = nomCamera;
    }

    public int getNbPlacesCamera() {
	return nbPlacesCamera;
    }

    public void setNbPlacesCamera(int nbPlacesCamera) {
	this.nbPlacesCamera = nbPlacesCamera;
    }

    public int getNbImagesCamera() {
	return nbImagesCamera;
    }

    public void setNbImagesCamera(int nbImagesCamera) {
	this.nbImagesCamera = nbImagesCamera;
    }
}
