
package fr.miage.orleans.modele.services.impl;

import fr.miage.orleans.modele.dao.CameraDao;
import fr.miage.orleans.modele.dao.ImageCameraDao;
import fr.miage.orleans.modele.entities.Camera;
import fr.miage.orleans.modele.entities.ImageCamera;
import fr.miage.orleans.modele.services.ServiceFluxPhotos;
import fr.miage.orleans.modele.services.valueobjects.CameraVoFluxPhotos;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Service
@Transactional
public class ServiceFluxPhotosImpl implements ServiceFluxPhotos {
    
    @Autowired
    private CameraDao cameraDao;
    
    @Autowired
    private ImageCameraDao imageCameraDao;
    
    @Override
    public Collection<CameraVoFluxPhotos> getAllCameras() {
	Collection<CameraVoFluxPhotos> camerasVoFluxPhotos = new ArrayList<CameraVoFluxPhotos>();
	for(Camera camera : this.cameraDao.findAll()) {
	    camerasVoFluxPhotos.add(new CameraVoFluxPhotos(camera));
	}
	return camerasVoFluxPhotos;
    }

    @Override
    public ImageCamera nouvelleImageCamera(byte[] imageByte, String nomCamera) {
	ImageCamera imageCamera = null;
	if(nomCamera != null && !nomCamera.isEmpty() && imageByte.length > 0) {
	    Camera camera = this.cameraDao.findByName(nomCamera);
	    if(camera != null) {
		imageCamera = new ImageCamera();
		imageCamera.setImageByte(imageByte);
		camera.getImagesCamera().add(imageCamera);
		this.cameraDao.edit(camera);
	    }
	}
	return imageCamera;
    }
    
}
