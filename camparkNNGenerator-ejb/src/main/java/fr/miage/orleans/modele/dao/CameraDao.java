
package fr.miage.orleans.modele.dao;

import fr.miage.orleans.modele.entities.Camera;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
public interface CameraDao extends AbstractDao<Camera>{
    public abstract Camera findByName(String nomCamera);
}
