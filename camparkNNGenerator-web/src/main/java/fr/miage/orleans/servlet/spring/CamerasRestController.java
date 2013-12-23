package fr.miage.orleans.servlet.spring;

import fr.miage.orleans.modele.entities.ImageCamera;
import fr.miage.orleans.modele.services.ServiceFluxPhotos;
import fr.miage.orleans.modele.services.valueobjects.CameraVoFluxPhotos;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Controller
@RequestMapping("/cameras")
public class CamerasRestController {

    @Autowired
    private ServiceFluxPhotos serviceFluxPhotos;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Collection<CameraVoFluxPhotos> getPlacesParking() {
	Collection<CameraVoFluxPhotos> placesParkingVoSystemeRue = this.serviceFluxPhotos.getAllCameras();
	return placesParkingVoSystemeRue;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFile(@RequestParam String nomCamera, @RequestParam MultipartFile file, MultipartHttpServletRequest request) {
	String res;
	if (nomCamera != null && !nomCamera.isEmpty() && file != null && !file.isEmpty()) {
	    System.out.println("nomCamera : " + nomCamera);
	    System.out.println("file.getSize() : " + file.getSize());
	    ImageCamera imageCamera = null;
	    try {
		imageCamera = this.serviceFluxPhotos.nouvelleImageCamera(file.getBytes(), nomCamera);
	    } catch (IOException ex) {
		Logger.getLogger(CamerasRestController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    if (imageCamera != null) {
		res = Boolean.toString(true);
	    } else {
		res = "Camera inexistante";
	    }
	} else {
	    res = "Parametres invalides";
	}

	return res;
    }

}
