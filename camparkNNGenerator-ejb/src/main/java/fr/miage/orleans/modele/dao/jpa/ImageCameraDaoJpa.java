
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.ImageCameraDao;
import fr.miage.orleans.modele.entities.ImageCamera;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class ImageCameraDaoJpa extends AbstractDaoJpa<ImageCamera> implements ImageCameraDao{
    
    public ImageCameraDaoJpa() {
	this(ImageCamera.class);
    }

    public ImageCameraDaoJpa(Class<ImageCamera> entityClass) {
	super(entityClass);
    }
    
}
