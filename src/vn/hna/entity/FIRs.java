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
@Table(name = "FIRs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FIRs.findAll", query = "SELECT f FROM FIRs f"),
    @NamedQuery(name = "FIRs.findByFirID", query = "SELECT f FROM FIRs f WHERE f.firID = :firID"),
    @NamedQuery(name = "FIRs.findByDateOfIncident", query = "SELECT f FROM FIRs f WHERE f.dateOfIncident = :dateOfIncident"),
    @NamedQuery(name = "FIRs.findByPlaceOfIncident", query = "SELECT f FROM FIRs f WHERE f.placeOfIncident = :placeOfIncident"),
    @NamedQuery(name = "FIRs.findByDescription", query = "SELECT f FROM FIRs f WHERE f.description = :description"),
    @NamedQuery(name = "FIRs.findByReasonDelay", query = "SELECT f FROM FIRs f WHERE f.reasonDelay = :reasonDelay"),
    @NamedQuery(name = "FIRs.findByCreatedDate", query = "SELECT f FROM FIRs f WHERE f.createdDate = :createdDate"),
    @NamedQuery(name = "FIRs.findByStatus", query = "SELECT f FROM FIRs f WHERE f.status = :status")})
public class FIRs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FirID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer firID;
    @Basic(optional = false)
    @Column(name = "DateOfIncident")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfIncident;
    @Basic(optional = false)
    @Column(name = "PlaceOfIncident")
    private String placeOfIncident;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Column(name = "ReasonDelay")
    private String reasonDelay;
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
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public FIRs() {
    }

    public FIRs(Integer firID) {
        this.firID = firID;
    }

    public FIRs(Integer firID, Date dateOfIncident, String placeOfIncident, String description, Date createdDate, short status) {
        this.firID = firID;
        this.dateOfIncident = dateOfIncident;
        this.placeOfIncident = placeOfIncident;
        this.description = description;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Integer getFirID() {
        return firID;
    }

    public void setFirID(Integer firID) {
        this.firID = firID;
    }

    public Date getDateOfIncident() {
        return dateOfIncident;
    }

    public void setDateOfIncident(Date dateOfIncident) {
        this.dateOfIncident = dateOfIncident;
    }

    public String getPlaceOfIncident() {
        return placeOfIncident;
    }

    public void setPlaceOfIncident(String placeOfIncident) {
        this.placeOfIncident = placeOfIncident;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReasonDelay() {
        return reasonDelay;
    }

    public void setReasonDelay(String reasonDelay) {
        this.reasonDelay = reasonDelay;
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

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (firID != null ? firID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FIRs)) {
            return false;
        }
        FIRs other = (FIRs) object;
        if ((this.firID == null && other.firID != null) || (this.firID != null && !this.firID.equals(other.firID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.FIRs[ firID=" + firID + " ]";
    }
    
}
