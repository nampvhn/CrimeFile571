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
@Table(name = "Victims")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Victims.findAll", query = "SELECT v FROM Victims v"),
    @NamedQuery(name = "Victims.findByVictimID", query = "SELECT v FROM Victims v WHERE v.victimID = :victimID"),
    @NamedQuery(name = "Victims.findByFullName", query = "SELECT v FROM Victims v WHERE v.fullName = :fullName"),
    @NamedQuery(name = "Victims.findByGender", query = "SELECT v FROM Victims v WHERE v.gender = :gender"),
    @NamedQuery(name = "Victims.findByBirthday", query = "SELECT v FROM Victims v WHERE v.birthday = :birthday"),
    @NamedQuery(name = "Victims.findByAddress", query = "SELECT v FROM Victims v WHERE v.address = :address"),
    @NamedQuery(name = "Victims.findByDescription", query = "SELECT v FROM Victims v WHERE v.description = :description"),
    @NamedQuery(name = "Victims.findByIsDead", query = "SELECT v FROM Victims v WHERE v.isDead = :isDead"),
    @NamedQuery(name = "Victims.findByRelativeName", query = "SELECT v FROM Victims v WHERE v.relativeName = :relativeName")})
public class Victims implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VictimID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer victimID;
    @Basic(optional = false)
    @Column(name = "FullName")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "Gender")
    private short gender;
    @Basic(optional = false)
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "IsDead")
    private boolean isDead;
    @Column(name = "RelativeName")
    private String relativeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "victimID")
    private List<Postmortems> postmortemsList;
    @JoinColumn(name = "CrID", referencedColumnName = "CrID")
    @ManyToOne(optional = false)
    private CaseRecords crID;

    public Victims() {
    }

    public Victims(Integer victimID) {
        this.victimID = victimID;
    }

    public Victims(Integer victimID, String fullName, short gender, Date birthday, String address, boolean isDead) {
        this.victimID = victimID;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.isDead = isDead;
    }

    public Integer getVictimID() {
        return victimID;
    }

    public void setVictimID(Integer victimID) {
        this.victimID = victimID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    @XmlTransient
    public List<Postmortems> getPostmortemsList() {
        return postmortemsList;
    }

    public void setPostmortemsList(List<Postmortems> postmortemsList) {
        this.postmortemsList = postmortemsList;
    }

    public CaseRecords getCrID() {
        return crID;
    }

    public void setCrID(CaseRecords crID) {
        this.crID = crID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (victimID != null ? victimID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Victims)) {
            return false;
        }
        Victims other = (Victims) object;
        if ((this.victimID == null && other.victimID != null) || (this.victimID != null && !this.victimID.equals(other.victimID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Victims[ victimID=" + victimID + " ]";
    }
    
}
