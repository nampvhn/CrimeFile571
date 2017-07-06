/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edison
 */
@Entity
@Table(name = "CrimeTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrimeTypes.findAll", query = "SELECT c FROM CrimeTypes c"),
    @NamedQuery(name = "CrimeTypes.findByCrimeTypeID", query = "SELECT c FROM CrimeTypes c WHERE c.crimeTypeID = :crimeTypeID"),
    @NamedQuery(name = "CrimeTypes.findByCrimeTypeName", query = "SELECT c FROM CrimeTypes c WHERE c.crimeTypeName = :crimeTypeName"),
    @NamedQuery(name = "CrimeTypes.findByDescription", query = "SELECT c FROM CrimeTypes c WHERE c.description = :description")})
public class CrimeTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CrimeTypeID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer crimeTypeID;
    @Basic(optional = false)
    @Column(name = "CrimeTypeName")
    private String crimeTypeName;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crimeTypeID")
    private List<CrimeCriminal> crimeCriminalList;

    public CrimeTypes() {
    }

    public CrimeTypes(Integer crimeTypeID) {
        this.crimeTypeID = crimeTypeID;
    }

    public CrimeTypes(Integer crimeTypeID, String crimeTypeName) {
        this.crimeTypeID = crimeTypeID;
        this.crimeTypeName = crimeTypeName;
    }

    public Integer getCrimeTypeID() {
        return crimeTypeID;
    }

    public void setCrimeTypeID(Integer crimeTypeID) {
        this.crimeTypeID = crimeTypeID;
    }

    public String getCrimeTypeName() {
        return crimeTypeName;
    }

    public void setCrimeTypeName(String crimeTypeName) {
        this.crimeTypeName = crimeTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<CrimeCriminal> getCrimeCriminalList() {
        return crimeCriminalList;
    }

    public void setCrimeCriminalList(List<CrimeCriminal> crimeCriminalList) {
        this.crimeCriminalList = crimeCriminalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crimeTypeID != null ? crimeTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrimeTypes)) {
            return false;
        }
        CrimeTypes other = (CrimeTypes) object;
        if ((this.crimeTypeID == null && other.crimeTypeID != null) || (this.crimeTypeID != null && !this.crimeTypeID.equals(other.crimeTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.CrimeTypes[ crimeTypeID=" + crimeTypeID + " ]";
    }
    
}
