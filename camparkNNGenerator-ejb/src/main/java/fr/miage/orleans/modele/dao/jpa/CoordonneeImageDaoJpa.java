
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.CoordonneeImageDao;
import fr.miage.orleans.modele.entities.CoordonneeImage;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class CoordonneeImageDaoJpa extends AbstractDaoJpa<CoordonneeImage> implements CoordonneeImageDao {

    public CoordonneeImageDaoJpa() {
	this(CoordonneeImage.class);
    }
    
    public CoordonneeImageDaoJpa(Class<CoordonneeImage> entityClass) {
	super(entityClass);
    }
    
}
