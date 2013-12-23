
package fr.miage.orleans.modele.dao;

import fr.miage.orleans.modele.entities.SystemeCentral;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public interface SystemeCentralDao extends AbstractDao<SystemeCentral> {
    public SystemeCentral findSelectionne();
}
