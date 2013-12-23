
package fr.miage.orleans.modele.services;

import fr.miage.orleans.modele.entities.ImageCamera;
import fr.miage.orleans.modele.services.valueobjects.CameraVoFluxPhotos;
import java.util.Collection;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public interface ServiceFluxPhotos {
    
    public Collection<CameraVoFluxPhotos> getAllCameras();
    
    public ImageCamera nouvelleImageCamera(byte[] imageByte, String nomCamera);
}
