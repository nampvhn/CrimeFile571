/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edison
 */
@Entity
@Table(name = "CaseRecords")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaseRecords.findAll", query = "SELECT c FROM CaseRecords c"),
    @NamedQuery(name = "CaseRecords.findByCrID", query = "SELECT c FROM CaseRecords c WHERE c.crID = :crID"),
    @NamedQuery(name = "CaseRecords.findByCrName", query = "SELECT c FROM CaseRecords c WHERE c.crName = :crName"),
    @NamedQuery(name = "CaseRecords.findByDateOfIncident", query = "SELECT c FROM CaseRecords c WHERE c.dateOfIncident = :dateOfIncident"),
    @NamedQuery(name = "CaseRecords.findByPlaceOfIncident", query = "SELECT c FROM CaseRecords c WHERE c.placeOfIncident = :placeOfIncident"),
    @NamedQuery(name = "CaseRecords.findByMotive", query = "SELECT c FROM CaseRecords c WHERE c.motive = :motive"),
    @NamedQuery(name = "CaseRecords.findByEvidence", query = "SELECT c FROM CaseRecords c WHERE c.evidence = :evidence"),
    @NamedQuery(name = "CaseRecords.findByDescription", query = "SELECT c FROM CaseRecords c WHERE c.description = :description"),
    @NamedQuery(name = "CaseRecords.findByLastUpdated", query = "SELECT c FROM CaseRecords c WHERE c.lastUpdated = :lastUpdated")})
public class CaseRecords implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CrID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer crID;
    @Basic(optional = false)
    @Column(name = "CrName")
    private String crName;
    @Basic(optional = false)
    @Column(name = "DateOfIncident")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfIncident;
    @Basic(optional = false)
    @Column(name = "PlaceOfIncident")
    private String placeOfIncident;
    @Basic(optional = false)
    @Column(name = "Motive")
    private String motive;
    @Basic(optional = false)
    @Column(name = "Evidence")
    private String evidence;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "LastUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crID")
    private List<CaseCriminal> caseCriminalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crID")
    private List<Victims> victimsList;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public CaseRecords() {
    }

    public CaseRecords(Integer crID) {
        this.crID = crID;
    }

    public CaseRecords(Integer crID, String crName, Date dateOfIncident, String placeOfIncident, String motive, String evidence, String description, Date lastUpdated) {
        this.crID = crID;
        this.crName = crName;
        this.dateOfIncident = dateOfIncident;
        this.placeOfIncident = placeOfIncident;
        this.motive = motive;
        this.evidence = evidence;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }

    public Integer getCrID() {
        return crID;
    }

    public void setCrID(Integer crID) {
        this.crID = crID;
    }

    public String getCrName() {
        return crName;
    }

    public void setCrName(String crName) {
        this.crName = crName;
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

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @XmlTransient
    public List<CaseCriminal> getCaseCriminalList() {
        return caseCriminalList;
    }

    public void setCaseCriminalList(List<CaseCriminal> caseCriminalList) {
        this.caseCriminalList = caseCriminalList;
    }

    @XmlTransient
    public List<Victims> getVictimsList() {
        return victimsList;
    }

    public void setVictimsList(List<Victims> victimsList) {
        this.victimsList = victimsList;
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
        hash += (crID != null ? crID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaseRecords)) {
            return false;
        }
        CaseRecords other = (CaseRecords) object;
        if ((this.crID == null && other.crID != null) || (this.crID != null && !this.crID.equals(other.crID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.CaseRecords[ crID=" + crID + " ]";
    }
    
}
