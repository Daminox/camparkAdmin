package fr.miage.orleans.modele.services.impl;

import fr.miage.orleans.modele.dao.SystemeCentralDao;
import fr.miage.orleans.modele.entities.SystemeCentral;
import fr.miage.orleans.modele.services.ServiceSystemeCentralSelectionne;
import fr.miage.orleans.modele.services.valueobjects.SystemeCentralVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Component
public class ServiceSystemeCentralSelectionneImpl implements ServiceSystemeCentralSelectionne {

    @Autowired
    private SystemeCentralDao systemeCentralDao;

    private SystemeCentral systemeCentral;

    private SystemeCentralVo systemeCentralVo;

    @Override
    public SystemeCentral getSystemeCentral() {
	if (this.systemeCentral == null) {
	    this.systemeCentral = this.systemeCentralDao.findSelectionne();
	    if (this.systemeCentral != null) {
		this.systemeCentralVo = new SystemeCentralVo(this.systemeCentral);
	    }
	}
	return this.systemeCentral;
    }

    @Override
    public void setSystemeCentral(SystemeCentral systemeCentral) {
	this.systemeCentral = systemeCentral;
	if (systemeCentral == null) {
	    this.systemeCentralVo = null;
	} else {
	    this.systemeCentralVo = new SystemeCentralVo(systemeCentral);
	}
    }

    @Override
    public SystemeCentralVo getSystemeCentralVo() {
	if(this.systemeCentralVo == null) {
	    this.getSystemeCentral();
	}
	return this.systemeCentralVo;
    }

}
