
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.PlaceCameraDao;
import fr.miage.orleans.modele.entities.PlaceCamera;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class PlaceCameraDaoJpa extends AbstractDaoJpa<PlaceCamera> implements PlaceCameraDao {

    public PlaceCameraDaoJpa() {
	this(PlaceCamera.class);
    }
    
    public PlaceCameraDaoJpa(Class<PlaceCamera> entityClass) {
	super(entityClass);
    }
}
