
package fr.miage.orleans.modele.pojoswebservice;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public interface PojoWebService {
    
    @JsonIgnore
    public String getIdToString();
}
