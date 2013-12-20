package fr.miage.orleans.modele.services;

import fr.miage.orleans.modele.entities.Camera;
import fr.miage.orleans.modele.entities.CoordonneeGPS;
import fr.miage.orleans.modele.entities.CoordonneeImage;
import fr.miage.orleans.modele.entities.ImageCamera;
import fr.miage.orleans.modele.entities.PlaceCamera;
import fr.miage.orleans.modele.entities.TransformationImage;

/**
 * 
 * Facade pour executer des actions simples
 */
public interface Facade {

    public Camera creerCamera(String nomCamera);
    
    public TransformationImage creerTransformation(int reduction, boolean isNoirEtBlanc);
    
    public Camera affecterTransformation(int idCamera, int idTransformationImage);
    
    public CoordonneeImage creerCoordonneeImage(int x1, int y1, int x2, int y2);
    
    public CoordonneeGPS creerCoordonneeGPS(double lattitude, double longittude);
    
    public PlaceCamera creerPlaceCamera(int idCamera, int numero, int idCoordonneeImage, int idCoordonneeGPS);
    
    public ImageCamera utiliserPourEntrainement(int idPlaceCamera, int idImageCameraTrain, boolean isOccupee);
    
    public PlaceCamera lancerEntrainement(int idPlaceCamera);
    
    public ImageCamera ajouterImage(byte[] imageByte, int idCamera );
    
    public boolean isCameraPretePourEntrainement(int idCamera);
    
    public boolean isCameraPretePourUtilisation(int idCamera);
        
}