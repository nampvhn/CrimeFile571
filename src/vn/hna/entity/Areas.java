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
@Table(name = "Areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a"),
    @NamedQuery(name = "Areas.findByAreaID", query = "SELECT a FROM Areas a WHERE a.areaID = :areaID"),
    @NamedQuery(name = "Areas.findByAreaName", query = "SELECT a FROM Areas a WHERE a.areaName = :areaName")})
public class Areas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AreaID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer areaID;
    @Column(name = "AreaName")
    private String areaName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaID")
    private List<Criminals> criminalsList;

    public Areas() {
    }

    public Areas(Integer areaID) {
        this.areaID = areaID;
    }
    
    public Areas(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @XmlTransient
    public List<Criminals> getCriminalsList() {
        return criminalsList;
    }

    public void setCriminalsList(List<Criminals> criminalsList) {
        this.criminalsList = criminalsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaID != null ? areaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.areaID == null && other.areaID != null) || (this.areaID != null && !this.areaID.equals(other.areaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Areas[ areaID=" + areaID + " ]";
    }
    
}
