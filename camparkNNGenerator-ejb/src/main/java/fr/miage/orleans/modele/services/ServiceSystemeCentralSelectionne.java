
package fr.miage.orleans.modele.services;

import fr.miage.orleans.modele.entities.SystemeCentral;
import fr.miage.orleans.modele.services.valueobjects.SystemeCentralVo;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public interface ServiceSystemeCentralSelectionne {
    
    public SystemeCentral getSystemeCentral();

    public void setSystemeCentral(SystemeCentral systemeCentral);

    public SystemeCentralVo getSystemeCentralVo();
}
