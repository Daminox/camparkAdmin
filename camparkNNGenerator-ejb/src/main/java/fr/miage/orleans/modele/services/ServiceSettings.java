
package fr.miage.orleans.modele.services;

import fr.miage.orleans.modele.entities.SystemeCentral;
import fr.miage.orleans.modele.services.valueobjects.SystemeCentralVo;
import java.util.Collection;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public interface ServiceSettings {
    
    public SystemeCentralVo getSystemeCentral(int id);
    
    public SystemeCentralVo getSystemeCentralSelectionne();
    
    public Collection<SystemeCentralVo> getAllSystemesCentral();
    
    public SystemeCentralVo createSystemeCentral(SystemeCentral systemeCentral);
    
    public SystemeCentralVo editSystemeCentral(int id , SystemeCentral systemeCentral);
    
    public SystemeCentralVo selectionnerSystemeCentral(int id);
    
    public void deselectionnerSystemeCentral();
}
