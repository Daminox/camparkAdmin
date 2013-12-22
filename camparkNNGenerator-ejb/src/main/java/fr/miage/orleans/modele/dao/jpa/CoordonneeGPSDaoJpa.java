
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.CoordonneeGPSDao;
import fr.miage.orleans.modele.entities.CoordonneeGPS;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class CoordonneeGPSDaoJpa extends AbstractDaoJpa<CoordonneeGPS> implements CoordonneeGPSDao{

    public CoordonneeGPSDaoJpa() {
	this(CoordonneeGPS.class);
    }
    
    public CoordonneeGPSDaoJpa(Class<CoordonneeGPS> entityClass) {
	super(entityClass);
    }
    
}
