
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.CameraDao;
import fr.miage.orleans.modele.entities.Camera;
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
    
}
