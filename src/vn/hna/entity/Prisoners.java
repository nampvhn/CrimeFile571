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
@Table(name = "Prisoners")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prisoners.findAll", query = "SELECT p FROM Prisoners p"),
    @NamedQuery(name = "Prisoners.findByPrisonerID", query = "SELECT p FROM Prisoners p WHERE p.prisonerID = :prisonerID"),
    @NamedQuery(name = "Prisoners.findByTimeInPrison", query = "SELECT p FROM Prisoners p WHERE p.timeInPrison = :timeInPrison"),
    @NamedQuery(name = "Prisoners.findByStartTime", query = "SELECT p FROM Prisoners p WHERE p.startTime = :startTime"),
    @NamedQuery(name = "Prisoners.findByEndTime", query = "SELECT p FROM Prisoners p WHERE p.endTime = :endTime")})
public class Prisoners implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PrisonerID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer prisonerID;
    @Basic(optional = false)
    @Column(name = "TimeInPrison")
    private String timeInPrison;
    @Basic(optional = false)
    @Column(name = "StartTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "EndTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @JoinColumn(name = "CriminalID", referencedColumnName = "CriminalID")
    @ManyToOne(optional = false)
    private Criminals criminalID;
    @JoinColumn(name = "PrisonID", referencedColumnName = "PrisonID")
    @ManyToOne(optional = false)
    private Prisons prisonID;

    public Prisoners() {
    }

    public Prisoners(Integer prisonerID) {
        this.prisonerID = prisonerID;
    }

    public Prisoners(Integer prisonerID, String timeInPrison, Date startTime, Date endTime) {
        this.prisonerID = prisonerID;
        this.timeInPrison = timeInPrison;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getPrisonerID() {
        return prisonerID;
    }

    public void setPrisonerID(Integer prisonerID) {
        this.prisonerID = prisonerID;
    }

    public String getTimeInPrison() {
        return timeInPrison;
    }

    public void setTimeInPrison(String timeInPrison) {
        this.timeInPrison = timeInPrison;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Criminals getCriminalID() {
        return criminalID;
    }

    public void setCriminalID(Criminals criminalID) {
        this.criminalID = criminalID;
    }

    public Prisons getPrisonID() {
        return prisonID;
    }

    public void setPrisonID(Prisons prisonID) {
        this.prisonID = prisonID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prisonerID != null ? prisonerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prisoners)) {
            return false;
        }
        Prisoners other = (Prisoners) object;
        if ((this.prisonerID == null && other.prisonerID != null) || (this.prisonerID != null && !this.prisonerID.equals(other.prisonerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Prisoners[ prisonerID=" + prisonerID + " ]";
    }
    
}
