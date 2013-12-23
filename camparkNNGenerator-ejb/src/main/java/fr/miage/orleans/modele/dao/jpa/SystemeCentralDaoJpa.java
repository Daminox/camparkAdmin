
package fr.miage.orleans.modele.dao.jpa;

import fr.miage.orleans.modele.dao.SystemeCentralDao;
import fr.miage.orleans.modele.entities.SystemeCentral;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class SystemeCentralDaoJpa extends AbstractDaoJpa<SystemeCentral> implements SystemeCentralDao {

    public SystemeCentralDaoJpa() {
	this(SystemeCentral.class);
    }
    
    public SystemeCentralDaoJpa(Class<SystemeCentral> entityClass) {
	super(entityClass);
    }
    
    @Override
    public SystemeCentral findSelectionne() {
	SystemeCentral systemeCentral = null;
	Query query = this.entityManager.createQuery("From SystemeCentral s where s.selectionne=:selectionne");
	query.setParameter("selectionne", 1);
	try {
	    systemeCentral = (SystemeCentral) query.getSingleResult();
	} catch (Exception ex) {
	    
	}
	return systemeCentral;
    }
}
