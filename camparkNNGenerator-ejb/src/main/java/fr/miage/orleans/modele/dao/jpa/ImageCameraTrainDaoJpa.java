
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.ImageCameraTrainDao;
import fr.miage.orleans.modele.entities.ImageCameraTrain;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class ImageCameraTrainDaoJpa extends AbstractDaoJpa<ImageCameraTrain> implements ImageCameraTrainDao {

    public ImageCameraTrainDaoJpa() {
	this(ImageCameraTrain.class);
    }
    
    public ImageCameraTrainDaoJpa(Class<ImageCameraTrain> entityClass) {
	super(entityClass);
    }
}
