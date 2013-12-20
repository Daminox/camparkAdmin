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
import javax.persistence.OneToOne;

/**
 *
 * @author Damien
 */
@Entity
public class ImageCameraTrain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean isOccupe;
    @OneToOne
    private ImageCamera image;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsOccupe() {
        return isOccupe;
    }

    public void setIsOccupe(boolean isOccupe) {
        this.isOccupe = isOccupe;
    }

    public ImageCamera getImage() {
        return image;
    }

    public void setImage(ImageCamera image) {
        this.image = image;
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
        if (!(object instanceof ImageCameraTrain)) {
            return false;
        }
        ImageCameraTrain other = (ImageCameraTrain) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.orleans.modele.entities.ImageCameraTrain[ id=" + id + " ]";
    }
    
}
