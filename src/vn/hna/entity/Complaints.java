/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edison
 */
@Entity
@Table(name = "Complaints")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complaints.findAll", query = "SELECT c FROM Complaints c"),
    @NamedQuery(name = "Complaints.findByCompID", query = "SELECT c FROM Complaints c WHERE c.compID = :compID"),
    @NamedQuery(name = "Complaints.findByDescription", query = "SELECT c FROM Complaints c WHERE c.description = :description"),
    @NamedQuery(name = "Complaints.findByCreatedDate", query = "SELECT c FROM Complaints c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Complaints.findByStatus", query = "SELECT c FROM Complaints c WHERE c.status = :status")})
public class Complaints implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CompID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer compID;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "Status")
    private short status;
    @JoinColumn(name = "ComplnID", referencedColumnName = "CplnID")
    @ManyToOne(optional = false)
    private Complainants complnID;
    @JoinColumn(name = "CplTypeID", referencedColumnName = "CplTypeID")
    @ManyToOne(optional = false)
    private ComplaintTypes cplTypeID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public Complaints() {
    }

    public Complaints(Integer compID) {
        this.compID = compID;
    }

    public Complaints(Integer compID, String description, Date createdDate, short status) {
        this.compID = compID;
        this.description = description;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Integer getCompID() {
        return compID;
    }

    public void setCompID(Integer compID) {
        this.compID = compID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Complainants getComplnID() {
        return complnID;
    }

    public void setComplnID(Complainants complnID) {
        this.complnID = complnID;
    }

    public ComplaintTypes getCplTypeID() {
        return cplTypeID;
    }

    public void setCplTypeID(ComplaintTypes cplTypeID) {
        this.cplTypeID = cplTypeID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compID != null ? compID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaints)) {
            return false;
        }
        Complaints other = (Complaints) object;
        if ((this.compID == null && other.compID != null) || (this.compID != null && !this.compID.equals(other.compID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Complaints[ compID=" + compID + " ]";
    }
    
}
