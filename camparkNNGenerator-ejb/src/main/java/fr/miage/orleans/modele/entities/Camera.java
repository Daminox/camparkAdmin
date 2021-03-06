package fr.miage.orleans.modele.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Damien
 */
@Entity
public class Camera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String nomCamera;

    @OneToOne
    private TransformationImage transformationImage;

    @OneToMany(mappedBy = "camera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<PlaceCamera> placesCamera;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<ImageCamera> imagesCamera;
    
    public Camera() {
	this.imagesCamera = new ArrayList<>();
	this.placesCamera = new ArrayList<>();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Collection<PlaceCamera> getPlacesCamera() {
	return placesCamera;
    }

    public void setPlacesCamera(Collection<PlaceCamera> placesCamera) {
	this.placesCamera = placesCamera;
    }

    public String getNomCamera() {
	return nomCamera;
    }

    public void setNomCamera(String nomCamera) {
	this.nomCamera = nomCamera;
    }

    public TransformationImage getTransformationImage() {
	return transformationImage;
    }

    public void setTransformationImage(TransformationImage transformationImage) {
	this.transformationImage = transformationImage;
    }

    public Collection<ImageCamera> getImagesCamera() {
	return imagesCamera;
    }

    public void setImagesCamera(Collection<ImageCamera> imagesCamera) {
	this.imagesCamera = imagesCamera;
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
	if (!(object instanceof Camera)) {
	    return false;
	}
	Camera other = (Camera) object;
	if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "fr.miage.orleans.modele.Camera[ id=" + id + " ]";
    }

}
