
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.CameraDao;
import fr.miage.orleans.modele.entities.Camera;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class CameraDaoJpa extends AbstractDaoJpa<Camera> implements CameraDao{

    public CameraDaoJpa() {
	this(Camera.class);
    }
    
    public CameraDaoJpa(Class<Camera> entityClass) {
	super(entityClass);
    }
    
    @Override
    public Camera findByName(String nomCamera) {
	Camera camera = null;
	Query query = this.entityManager.createQuery("From Camera c where c.nomCamera=:nomCamera");
	query.setParameter("nomCamera", nomCamera);
	try {
	    camera = (Camera) query.getSingleResult();
	} catch (Exception ex) {

	}
	return camera;
    }
    
}
