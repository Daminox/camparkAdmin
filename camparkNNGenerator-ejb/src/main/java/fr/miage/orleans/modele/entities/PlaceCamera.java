/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.miage.orleans.modele.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Damien
 */
@Entity
public class PlaceCamera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String NNet;
    private int numeroPlace;
    
    @OneToOne
    private CoordonneeImage coordonneeImage;
    
    @OneToOne
    private CoordonneeGPS coordonneeGPS;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Camera camera;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<ImageCameraTrain> imagesTrain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoordonneeGPS getCoordonneeGPS() {
        return coordonneeGPS;
    }

    public void setCoordonneeGPS(CoordonneeGPS coordonneeGPS) {
        this.coordonneeGPS = coordonneeGPS;
    }

    public String getPathToNNetFile() {
        return NNet;
    }

    public void setPathToNNetFile(String pathToNNetFile) {
        this.NNet = pathToNNetFile;
    }

    public int getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(int numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public CoordonneeImage getCoordonneeImage() {
        return coordonneeImage;
    }

    public void setCoordonneeImage(CoordonneeImage coordonneeImage) {
        this.coordonneeImage = coordonneeImage;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getNNet() {
        return NNet;
    }

    public void setNNet(String NNet) {
        this.NNet = NNet;
    }

    public Collection<ImageCameraTrain> getImagesTrain() {
        return imagesTrain;
    }

    public void setImagesTrain(Collection<ImageCameraTrain> imagesTrain) {
        this.imagesTrain = imagesTrain;
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
        if (!(object instanceof PlaceCamera)) {
            return false;
        }
        PlaceCamera other = (PlaceCamera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.orleans.modele.PlaceCamera[ id=" + id + " ]";
    }
    
}
