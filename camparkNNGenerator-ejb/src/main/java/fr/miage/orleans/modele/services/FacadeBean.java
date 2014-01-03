/**
 *
 */
package fr.miage.orleans.modele.services;

import fr.miage.orleans.modele.dao.CameraDao;
import fr.miage.orleans.modele.dao.CoordonneeGPSDao;
import fr.miage.orleans.modele.dao.CoordonneeImageDao;
import fr.miage.orleans.modele.dao.PlaceCameraDao;
import fr.miage.orleans.modele.dao.PlaceDao;
import fr.miage.orleans.modele.entities.Camera;
import fr.miage.orleans.modele.entities.CoordonneeGPS;
import fr.miage.orleans.modele.entities.CoordonneeImage;
import fr.miage.orleans.modele.entities.ImageCamera;
import fr.miage.orleans.modele.entities.PlaceCamera;
import fr.miage.orleans.modele.entities.TransformationImage;
import fr.miage.orleans.modele.pojoswebservice.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Steve Cancès <steve.cances@gmail.com>
 *
 */
@Service
@Transactional
public class FacadeBean implements FacadeLocal {

    @Autowired
    private CoordonneeImageDao coordonneeImageDao;

    @Autowired
    private CoordonneeGPSDao coordonneeGPSDao;

    @Autowired
    private CameraDao cameraDao;

    @Autowired
    private PlaceCameraDao placeCameraDao;

    @Autowired
    private PlaceDao placeDao;

    @Override
    public CoordonneeImage creerCoordonneeImage(int x1, int y1, int x2, int y2) {
	CoordonneeImage coordonneeImage = new CoordonneeImage();
	coordonneeImage.setX1(x1);
	coordonneeImage.setX2(x2);
	coordonneeImage.setY1(y1);
	coordonneeImage.setY2(y2);
	this.coordonneeImageDao.create(coordonneeImage);
	return coordonneeImage;
    }

    @Override
    public CoordonneeGPS creerCoordonneeGPS(double lattitude, double longittude) {
	CoordonneeGPS coordonneeGPS = new CoordonneeGPS();
	coordonneeGPS.setLattitude(lattitude);
	coordonneeGPS.setLongitude(longittude);
	this.coordonneeGPSDao.create(coordonneeGPS);
	return coordonneeGPS;
    }

    @Override
    public PlaceCamera creerPlaceCamera(long idCamera, int numero, long idCoordonneeImage, long idCoordonneeGPS) {
	System.out.println("creerPlaceCamera");
	Camera camera = this.cameraDao.find(idCamera);
	CoordonneeGPS coordonneeGPS = this.coordonneeGPSDao.find(idCoordonneeGPS);
	CoordonneeImage coordonneeImage = this.coordonneeImageDao.find(idCoordonneeImage);
	PlaceCamera placeCamera = new PlaceCamera();
	placeCamera.setCamera(camera);
	placeCamera.setNumeroPlace(numero);
	placeCamera.setCoordonneeGPS(coordonneeGPS);
	placeCamera.setCoordonneeImage(coordonneeImage);
	this.placeCameraDao.create(placeCamera);

	/*
	 * WS
	 */
	Place place = new Place();
	place.setNumero(placeCamera.getId());
	place.setLatitude(coordonneeGPS.getLattitude());
	place.setLongitude(coordonneeGPS.getLongitude());
	// pas de libre ??
	place.setLibre(true);
	this.placeDao.create(place);

	return placeCamera;
    }

    @Override
    public Camera creerCamera(String nomCamera) {
	Camera camera = null;
	if (nomCamera != null && !nomCamera.isEmpty()) {
	    camera = new Camera();
	    camera.setNomCamera(nomCamera);
	    this.cameraDao.create(camera);
	}
	return camera;
    }

    @Override
    public TransformationImage creerTransformation(int reduction, boolean isNoirEtBlanc) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Camera affecterTransformation(int idCamera, int idTransformationImage) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageCamera utiliserPourEntrainement(int idPlaceCamera, int idImageCameraTrain, boolean isOccupee) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlaceCamera lancerEntrainement(int idPlaceCamera) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageCamera ajouterImage(byte[] imageByte, int idCamera) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCameraPretePourEntrainement(int idCamera) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCameraPretePourUtilisation(int idCamera) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
