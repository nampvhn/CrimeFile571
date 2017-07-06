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
@Table(name = "Prisons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prisons.findAll", query = "SELECT p FROM Prisons p"),
    @NamedQuery(name = "Prisons.findByPrisonID", query = "SELECT p FROM Prisons p WHERE p.prisonID = :prisonID"),
    @NamedQuery(name = "Prisons.findByPrisonName", query = "SELECT p FROM Prisons p WHERE p.prisonName = :prisonName"),
    @NamedQuery(name = "Prisons.findByAddress", query = "SELECT p FROM Prisons p WHERE p.address = :address")})
public class Prisons implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PrisonID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer prisonID;
    @Basic(optional = false)
    @Column(name = "PrisonName")
    private String prisonName;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prisonID")
    private List<Prisoners> prisonersList;

    public Prisons() {
    }

    public Prisons(Integer prisonID) {
        this.prisonID = prisonID;
    }

    public Prisons(Integer prisonID, String prisonName, String address) {
        this.prisonID = prisonID;
        this.prisonName = prisonName;
        this.address = address;
    }

    public Integer getPrisonID() {
        return prisonID;
    }

    public void setPrisonID(Integer prisonID) {
        this.prisonID = prisonID;
    }

    public String getPrisonName() {
        return prisonName;
    }

    public void setPrisonName(String prisonName) {
        this.prisonName = prisonName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public List<Prisoners> getPrisonersList() {
        return prisonersList;
    }

    public void setPrisonersList(List<Prisoners> prisonersList) {
        this.prisonersList = prisonersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prisonID != null ? prisonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prisons)) {
            return false;
        }
        Prisons other = (Prisons) object;
        if ((this.prisonID == null && other.prisonID != null) || (this.prisonID != null && !this.prisonID.equals(other.prisonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Prisons[ prisonID=" + prisonID + " ]";
    }
    
}
