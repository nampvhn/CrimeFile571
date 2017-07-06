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
@Table(name = "CaseCriminal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaseCriminal.findAll", query = "SELECT c FROM CaseCriminal c"),
    @NamedQuery(name = "CaseCriminal.findByCcID", query = "SELECT c FROM CaseCriminal c WHERE c.ccID = :ccID")})
public class CaseCriminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CcID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ccID;
    @JoinColumn(name = "CrID", referencedColumnName = "CrID")
    @ManyToOne(optional = false)
    private CaseRecords crID;
    @JoinColumn(name = "CriminalID", referencedColumnName = "CriminalID")
    @ManyToOne(optional = false)
    private Criminals criminalID;

    public CaseCriminal() {
    }

    public CaseCriminal(Integer ccID) {
        this.ccID = ccID;
    }

    public Integer getCcID() {
        return ccID;
    }

    public void setCcID(Integer ccID) {
        this.ccID = ccID;
    }

    public CaseRecords getCrID() {
        return crID;
    }

    public void setCrID(CaseRecords crID) {
        this.crID = crID;
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
        hash += (ccID != null ? ccID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaseCriminal)) {
            return false;
        }
        CaseCriminal other = (CaseCriminal) object;
        if ((this.ccID == null && other.ccID != null) || (this.ccID != null && !this.ccID.equals(other.ccID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.CaseCriminal[ ccID=" + ccID + " ]";
    }
    
}
