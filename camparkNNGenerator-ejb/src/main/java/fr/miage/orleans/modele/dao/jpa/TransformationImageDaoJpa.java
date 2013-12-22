
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.TransformationImageDao;
import fr.miage.orleans.modele.entities.TransformationImage;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class TransformationImageDaoJpa extends AbstractDaoJpa<TransformationImage> implements TransformationImageDao{

    public TransformationImageDaoJpa() {
	this(TransformationImage.class);
    }
    
    public TransformationImageDaoJpa(Class<TransformationImage> entityClass) {
	super(entityClass);
    }
    
}
