
package fr.miage.orleans.servlet.spring;

import fr.miage.orleans.modele.entities.Camera;
import fr.miage.orleans.modele.entities.CoordonneeGPS;
import fr.miage.orleans.modele.entities.CoordonneeImage;
import fr.miage.orleans.modele.services.Facade;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Controller
@RequestMapping("/test")
public class TestRestController {
    
    @Autowired
    private Facade facade;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    String test() {
	System.out.println("/test/");
	Camera camera = this.facade.creerCamera(new BigInteger(130, new SecureRandom()).toString(32));
	
	CoordonneeImage coordonneeImage = this.facade.creerCoordonneeImage(1, 1, 2, 2);
	CoordonneeGPS coordonneeGPS = this.facade.creerCoordonneeGPS(1, 1);
	
	this.facade.creerPlaceCamera(camera.getId(), 1, coordonneeImage.getId(), coordonneeGPS.getId());
	return "ok";
    }
    
}
