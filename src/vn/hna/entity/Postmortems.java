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
@Table(name = "Postmortems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postmortems.findAll", query = "SELECT p FROM Postmortems p"),
    @NamedQuery(name = "Postmortems.findByPostmortemID", query = "SELECT p FROM Postmortems p WHERE p.postmortemID = :postmortemID"),
    @NamedQuery(name = "Postmortems.findByDateOfDeath", query = "SELECT p FROM Postmortems p WHERE p.dateOfDeath = :dateOfDeath"),
    @NamedQuery(name = "Postmortems.findByReason", query = "SELECT p FROM Postmortems p WHERE p.reason = :reason"),
    @NamedQuery(name = "Postmortems.findByDescription", query = "SELECT p FROM Postmortems p WHERE p.description = :description"),
    @NamedQuery(name = "Postmortems.findByDateOfReport", query = "SELECT p FROM Postmortems p WHERE p.dateOfReport = :dateOfReport"),
    @NamedQuery(name = "Postmortems.findByDoctorName", query = "SELECT p FROM Postmortems p WHERE p.doctorName = :doctorName"),
    @NamedQuery(name = "Postmortems.findByHospitalName", query = "SELECT p FROM Postmortems p WHERE p.hospitalName = :hospitalName")})
public class Postmortems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PostmortemID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer postmortemID;
    @Basic(optional = false)
    @Column(name = "DateOfDeath")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfDeath;
    @Basic(optional = false)
    @Column(name = "Reason")
    private String reason;
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "DateOfReport")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfReport;
    @Basic(optional = false)
    @Column(name = "DoctorName")
    private String doctorName;
    @Basic(optional = false)
    @Column(name = "HospitalName")
    private String hospitalName;
    @JoinColumn(name = "VictimID", referencedColumnName = "VictimID")
    @ManyToOne(optional = false)
    private Victims victimID;

    public Postmortems() {
    }

    public Postmortems(Integer postmortemID) {
        this.postmortemID = postmortemID;
    }

    public Postmortems(Integer postmortemID, Date dateOfDeath, String reason, Date dateOfReport, String doctorName, String hospitalName) {
        this.postmortemID = postmortemID;
        this.dateOfDeath = dateOfDeath;
        this.reason = reason;
        this.dateOfReport = dateOfReport;
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
    }

    public Integer getPostmortemID() {
        return postmortemID;
    }

    public void setPostmortemID(Integer postmortemID) {
        this.postmortemID = postmortemID;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(Date dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Victims getVictimID() {
        return victimID;
    }

    public void setVictimID(Victims victimID) {
        this.victimID = victimID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postmortemID != null ? postmortemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postmortems)) {
            return false;
        }
        Postmortems other = (Postmortems) object;
        if ((this.postmortemID == null && other.postmortemID != null) || (this.postmortemID != null && !this.postmortemID.equals(other.postmortemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Postmortems[ postmortemID=" + postmortemID + " ]";
    }
    
}
