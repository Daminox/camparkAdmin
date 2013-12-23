package fr.miage.orleans.modele.services.impl;

import fr.miage.orleans.modele.dao.SystemeCentralDao;
import fr.miage.orleans.modele.entities.SystemeCentral;
import fr.miage.orleans.modele.services.ServiceSettings;
import fr.miage.orleans.modele.services.valueobjects.SystemeCentralVo;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steve Cancès <steve.cances@gmail.com>
 */
@Service
@Transactional
public class ServiceSettingsImpl implements ServiceSettings {

    @Autowired
    private SystemeCentralDao systemeCentralDao;

    @Override
    public SystemeCentralVo getSystemeCentral(int id) {
	SystemeCentralVo systemeCentralVo = null;
	SystemeCentral systemeCentral = this.systemeCentralDao.find(id);
	if (systemeCentral != null) {
	    systemeCentralVo = new SystemeCentralVo(systemeCentral);
	}
	return systemeCentralVo;
    }

    @Override
    public SystemeCentralVo getSystemeCentralSelectionne() {
	SystemeCentralVo systemeCentralVo = null;
	SystemeCentral systemeCentral = this.systemeCentralDao.findSelectionne();
	if (systemeCentral != null) {
	    systemeCentralVo = new SystemeCentralVo(systemeCentral);
	}
	return systemeCentralVo;

    }

    @Override
    public Collection<SystemeCentralVo> getAllSystemesCentral() {
	Collection<SystemeCentralVo> systemesCentralVo = new ArrayList<SystemeCentralVo>();
	for (SystemeCentral systemeCentral : this.systemeCentralDao.findAll()) {
	    systemesCentralVo.add(new SystemeCentralVo(systemeCentral));
	}
	return systemesCentralVo;
    }

    @Override
    public SystemeCentralVo createSystemeCentral(SystemeCentral systemeCentral) {
	SystemeCentralVo systemeCentralVo = null;
	if (systemeCentral != null) {
	    if (this.systemeCentralDao.findSelectionne() != null) {
		systemeCentral.setSelectionne(false);
	    }
	    this.systemeCentralDao.create(systemeCentral);
	    systemeCentralVo = new SystemeCentralVo(systemeCentral);
	}
	return systemeCentralVo;
    }

    @Override
    public SystemeCentralVo editSystemeCentral(int id, SystemeCentral systemeCentral) {
	SystemeCentralVo systemeCentralVo = null;
	if (systemeCentral != null) {
	    SystemeCentral systemeCentralSelectionne = this.systemeCentralDao.findSelectionne();
	    if (systemeCentralSelectionne != null && systemeCentralSelectionne.getId() != id) {
		systemeCentral.setSelectionne(false);
	    }
	    this.systemeCentralDao.edit(systemeCentral);
	    systemeCentralVo = new SystemeCentralVo(systemeCentral);
	}
	return systemeCentralVo;
    }

    @Override
    public SystemeCentralVo selectionnerSystemeCentral(int id) {
	SystemeCentralVo systemeCentralVo = null;
	SystemeCentral systemeCentral = this.systemeCentralDao.find(id);
	if (systemeCentral != null) {
	    for (SystemeCentral iSystemeCentral : this.systemeCentralDao.findAll()) {
		iSystemeCentral.setSelectionne(iSystemeCentral.equals(systemeCentral));
		this.systemeCentralDao.edit(iSystemeCentral);
	    }
	    systemeCentralVo = new SystemeCentralVo(this.systemeCentralDao.find(id));
	}
	return systemeCentralVo;
    }

    @Override
    public void deselectionnerSystemeCentral() {
	for (SystemeCentral iSystemeCentral : this.systemeCentralDao.findAll()) {
	    iSystemeCentral.setSelectionne(false);
	    this.systemeCentralDao.edit(iSystemeCentral);
	}
    }

}
