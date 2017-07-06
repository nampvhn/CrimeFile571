/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edison
 */
@Entity
@Table(name = "CrimeCriminal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrimeCriminal.findAll", query = "SELECT c FROM CrimeCriminal c"),
    @NamedQuery(name = "CrimeCriminal.findByCrimeID", query = "SELECT c FROM CrimeCriminal c WHERE c.crimeID = :crimeID")})
public class CrimeCriminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CrimeID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer crimeID;
    @JoinColumn(name = "CrimeTypeID", referencedColumnName = "CrimeTypeID")
    @ManyToOne(optional = false)
    private CrimeTypes crimeTypeID;
    @JoinColumn(name = "CriminalID", referencedColumnName = "CriminalID")
    @ManyToOne(optional = false)
    private Criminals criminalID;

    public CrimeCriminal() {
    }

    public CrimeCriminal(Integer crimeID) {
        this.crimeID = crimeID;
    }

    public Integer getCrimeID() {
        return crimeID;
    }

    public void setCrimeID(Integer crimeID) {
        this.crimeID = crimeID;
    }

    public CrimeTypes getCrimeTypeID() {
        return crimeTypeID;
    }

    public void setCrimeTypeID(CrimeTypes crimeTypeID) {
        this.crimeTypeID = crimeTypeID;
    }

    public Criminals getCriminalID() {
        return criminalID;
    }

    public void setCriminalID(Criminals criminalID) {
        this.criminalID = criminalID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crimeID != null ? crimeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrimeCriminal)) {
            return false;
        }
        CrimeCriminal other = (CrimeCriminal) object;
        if ((this.crimeID == null && other.crimeID != null) || (this.crimeID != null && !this.crimeID.equals(other.crimeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.CrimeCriminal[ crimeID=" + crimeID + " ]";
    }
    
}
