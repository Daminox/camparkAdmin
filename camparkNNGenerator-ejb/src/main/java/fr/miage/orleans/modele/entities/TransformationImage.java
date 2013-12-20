/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.miage.orleans.modele.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Damien
 */
@Entity
public class TransformationImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int pourcentageReduction;
    private boolean noirEtBlanc;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPourcentageReduction() {
        return pourcentageReduction;
    }

    public void setPourcentageReduction(int pourcentageReduction) {
        this.pourcentageReduction = pourcentageReduction;
    }

    public boolean isNoirEtBlanc() {
        return noirEtBlanc;
    }

    public void setNoirEtBlanc(boolean noirEtBlanc) {
        this.noirEtBlanc = noirEtBlanc;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransformationImage)) {
            return false;
        }
        TransformationImage other = (TransformationImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.orleans.modele.entities.TransformationImage[ id=" + id + " ]";
    }
    
}
