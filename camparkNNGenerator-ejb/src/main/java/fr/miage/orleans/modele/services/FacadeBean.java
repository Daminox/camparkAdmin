/**
 *
 */
package fr.miage.orleans.modele.services;

import fr.miage.orleans.modele.entities.Camera;
import fr.miage.orleans.modele.entities.CoordonneeGPS;
import fr.miage.orleans.modele.entities.CoordonneeImage;
import fr.miage.orleans.modele.entities.PlaceCamera;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * @author Steve Cancès <steve.cances@gmail.com>
 *
 */
@Stateless
@LocalBean
public class FacadeBean implements FacadeLocal {

    @PersistenceContext(unitName = FacadeUtils.PERSISTENCE_CONTEXT_UNIT_NAME)
    private EntityManager entityManager;
    
    @Override
    public Camera creerCamera(String nomCamera, String inputFolder, String outputFolderPattern) {
        Camera camera = new Camera();
        camera.setNomCamera(nomCamera);
        camera.setPathToRawFolder(inputFolder);
        camera.setPathToTrainFolderPatter(outputFolderPattern);
        entityManager.persist(camera);
        return camera;
    }

    @Override
    public CoordonneeImage creerCoordonneeImage(int x1, int y1, int x2, int y2) {
        CoordonneeImage coordonneeImage = new CoordonneeImage();
        coordonneeImage.setX1(x1);
        coordonneeImage.setX2(x2);
        coordonneeImage.setY1(y1);
        coordonneeImage.setY2(y2);
        entityManager.persist(coordonneeImage);
        return coordonneeImage;
    }

    @Override
    public CoordonneeGPS creerCoordonneeGPS(double lattitude, double longittude) {
        CoordonneeGPS coordonneeGPS = new CoordonneeGPS();
        coordonneeGPS.setLattitude(lattitude);
        coordonneeGPS.setLongitude(longittude);
        entityManager.persist(coordonneeGPS);
        return coordonneeGPS;
    }

    @Override
    public PlaceCamera creerPlaceCamera(int idCamera, int numero, int idCoordonneeImage, int idCoordonneeGPS) {
        
        Camera camera = entityManager.find(Camera.class, idCamera);
        CoordonneeGPS coordonneeGPS = entityManager.find(CoordonneeGPS.class, idCoordonneeGPS);
        CoordonneeImage coordonneeImage = entityManager.find(CoordonneeImage.class, idCoordonneeImage);
        PlaceCamera placeCamera = new PlaceCamera();
        placeCamera.setCamera(camera);
        placeCamera.setNumeroPlace(numero);
        placeCamera.setCoordonneeGPS(coordonneeGPS);
        placeCamera.setCoordonneeImage(coordonneeImage);
        placeCamera.setPathToTrainFolderPatter(camera.getPathToTrainFolderPatter() + numero + "/");
        entityManager.persist(placeCamera);
        return placeCamera;
    }

    @Override
    public boolean cropImages(int idCamera) {
        Camera camera = entityManager.find(Camera.class, idCamera);
        
        return true;
    }

}