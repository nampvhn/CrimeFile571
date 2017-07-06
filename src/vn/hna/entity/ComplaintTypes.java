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
@Table(name = "ComplaintTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComplaintTypes.findAll", query = "SELECT c FROM ComplaintTypes c"),
    @NamedQuery(name = "ComplaintTypes.findByCplTypeID", query = "SELECT c FROM ComplaintTypes c WHERE c.cplTypeID = :cplTypeID"),
    @NamedQuery(name = "ComplaintTypes.findByCplTypeName", query = "SELECT c FROM ComplaintTypes c WHERE c.cplTypeName = :cplTypeName"),
    @NamedQuery(name = "ComplaintTypes.findByDescription", query = "SELECT c FROM ComplaintTypes c WHERE c.description = :description")})
public class ComplaintTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CplTypeID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cplTypeID;
    @Basic(optional = false)
    @Column(name = "CplTypeName")
    private String cplTypeName;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cplTypeID")
    private List<Complaints> complaintsList;

    public ComplaintTypes() {
    }

    public ComplaintTypes(Integer cplTypeID) {
        this.cplTypeID = cplTypeID;
    }

    public ComplaintTypes(Integer cplTypeID, String cplTypeName) {
        this.cplTypeID = cplTypeID;
        this.cplTypeName = cplTypeName;
    }

    public Integer getCplTypeID() {
        return cplTypeID;
    }

    public void setCplTypeID(Integer cplTypeID) {
        this.cplTypeID = cplTypeID;
    }

    public String getCplTypeName() {
        return cplTypeName;
    }

    public void setCplTypeName(String cplTypeName) {
        this.cplTypeName = cplTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Complaints> getComplaintsList() {
        return complaintsList;
    }

    public void setComplaintsList(List<Complaints> complaintsList) {
        this.complaintsList = complaintsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cplTypeID != null ? cplTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplaintTypes)) {
            return false;
        }
        ComplaintTypes other = (ComplaintTypes) object;
        if ((this.cplTypeID == null && other.cplTypeID != null) || (this.cplTypeID != null && !this.cplTypeID.equals(other.cplTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.ComplaintTypes[ cplTypeID=" + cplTypeID + " ]";
    }
    
}
