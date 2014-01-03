package fr.miage.orleans.modele.dao.restwebservice;

import fr.miage.orleans.modele.pojoswebservice.PojoWebService;
import fr.miage.orleans.modele.dao.AbstractDao;
import fr.miage.orleans.modele.services.ServiceSystemeCentralSelectionne;
import fr.miage.orleans.modele.services.valueobjects.SystemeCentralVo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.atteo.evo.inflector.English;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 * @param <T> Le PojoWebService gérée par la dao
 */
@Component
public abstract class AbstractDaoRestWebService<T extends PojoWebService> implements AbstractDao<T> {

    @Autowired
    protected ServiceSystemeCentralSelectionne serviceSystemeCentralSelectionne;

    protected final Class<T> domainClass;

    protected final String simpleName;

    protected HttpClient httpclient;

    protected final ObjectMapper mapper;

    protected HttpResponse lastResponse;

    public AbstractDaoRestWebService(Class<T> entityClass) {
	this.domainClass = entityClass;
	this.simpleName = English.plural(this.domainClass.getSimpleName().toLowerCase());
	this.httpclient = HttpClientBuilder.create().build();
	this.mapper = new ObjectMapper();
	this.lastResponse = null;
    }

    public String getLastResponseToString() {
	return lastResponse.toString();
    }

    protected SystemeCentralVo getSystemeCentralSelectionne() {
	return this.serviceSystemeCentralSelectionne.getSystemeCentralVo();
    }

    protected String getUrl() {
	SystemeCentralVo systemeCentralVo = this.getSystemeCentralSelectionne();
	if (systemeCentralVo != null) {
	    return systemeCentralVo.getUrlComplete() + "/" + this.simpleName;
	} else {
	    return null;
	}
    }

    @Override
    public void create(T entity) {
	String url = this.getUrl();
	System.out.println("create place url : "+url);
	if (url != null && !url.isEmpty()) {
	    HttpPost httpPost = new HttpPost(url);
	    httpPost.addHeader("charset", "utf-8");
	    httpPost.addHeader("Content-Type", "application/json");
	    
	    try {
		String entityAsJsonString = this.mapper.writeValueAsString(entity);
		System.out.println("json : "+entityAsJsonString);
		StringEntity input = new StringEntity(entityAsJsonString);
		input.setContentType("application/json");
		httpPost.setEntity(input);
	    } catch (UnsupportedEncodingException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	    try {
		System.out.println("avant execute");
		this.lastResponse = this.httpclient.execute(httpPost);
		System.out.println("apres execute -> status : "+this.lastResponse.getStatusLine().getStatusCode());
	    } catch (IOException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    @Override
    public void edit(T entity) {
	String url = this.getUrl();
	if (url != null && !url.isEmpty()) {
	    HttpPut httpPut = new HttpPut(url + "/" + entity.getIdToString());
	    httpPut.addHeader("charset", "utf-8");
	    httpPut.addHeader("Content-Type", "application/json");
	    
	    try {
		String entityAsJsonString = this.mapper.writeValueAsString(entity);
		System.out.println("json : "+entityAsJsonString);
		StringEntity input = new StringEntity(entityAsJsonString);
		input.setContentType("application/json");
		httpPut.setEntity(input);
	    } catch (UnsupportedEncodingException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
	    try {
		System.out.println("avant execute");
		this.lastResponse = this.httpclient.execute(httpPut);
		System.out.println("apres execute -> status : "+this.lastResponse.getStatusLine().getStatusCode());
	    } catch (IOException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    @Override
    public void remove(T entity) {
	String url = this.getUrl();
	if (url != null && !url.isEmpty()) {
	    HttpDelete httpDelete = new HttpDelete(url + "/" + entity.getIdToString());
	    try {
		this.lastResponse = this.httpclient.execute(httpDelete);
	    } catch (IOException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    @Override
    public T find(Object id) {
	T res = null;
	String url = this.getUrl();
	if (url != null && !url.isEmpty()) {
	    HttpGet httpGet = new HttpGet(url + "/" + id.toString());
	    try {
		this.lastResponse = this.httpclient.execute(httpGet);
		res = this.mapper.readValue(this.lastResponse.getEntity().getContent(), this.domainClass);
	    } catch (IOException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return res;
    }

    @Override
    public List<T> findAll() {
	List<T> res = null;
	String url = this.getUrl();
	if (url != null && !url.isEmpty()) {
	    HttpGet httpGet = new HttpGet(url);
	    try {
		this.lastResponse = this.httpclient.execute(httpGet);
		res = this.mapper.readValue(this.lastResponse.getEntity().getContent(), TypeFactory.defaultInstance().constructParametricType(List.class, this.domainClass));
	    } catch (IOException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return res;
    }

    @Override
    public List<T> findRange(int[] range) {
	List<T> res = this.findAll();
	if (res != null) {
	    try {
		res = res.subList(range[0], range[1]);
	    } catch (ArrayIndexOutOfBoundsException ex) {
		Logger.getLogger(AbstractDaoRestWebService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return res;
    }

    @Override
    public int count() {
	int res = 0;
	List<T> items = this.findAll();
	if (items != null) {
	    res = items.size();
	}
	return res;
    }

}
