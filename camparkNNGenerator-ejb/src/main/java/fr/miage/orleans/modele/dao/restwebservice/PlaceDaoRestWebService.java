package fr.miage.orleans.modele.dao.restwebservice;

import fr.miage.orleans.modele.dao.PlaceDao;
import fr.miage.orleans.modele.pojoswebservice.Place;
import fr.miage.orleans.modele.services.valueobjects.SystemeCentralVo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Repository
public class PlaceDaoRestWebService extends AbstractDaoRestWebService<Place> implements PlaceDao {

    public PlaceDaoRestWebService() {
	this(Place.class);
    }

    public PlaceDaoRestWebService(Class<Place> entityClass) {
	super(entityClass);
    }

    protected boolean logIn() {
	boolean res = false;
	SystemeCentralVo systemeCentralVo = this.getSystemeCentralSelectionne();
	if (systemeCentralVo != null) {
	    String url = systemeCentralVo.getUrlComplete() + "/login/" + systemeCentralVo.getAuthKey();
	    System.out.println("login url : " + url);
	    HttpGet httpGet = new HttpGet(url);
	    try {
		this.lastResponse = this.httpclient.execute(httpGet);
		res = this.mapper.readValue(this.lastResponse.getEntity().getContent(), boolean.class);
	    } catch (IOException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return res;
    }

    @Override
    public void create(Place entity) {
	System.out.println("PlaceDaoRestWebService create");
	this.httpclient = HttpClientBuilder.create().build();
	boolean resLogin = this.logIn();
	System.out.println("res logIn : " + resLogin);
	super.create(entity);
    }
}
