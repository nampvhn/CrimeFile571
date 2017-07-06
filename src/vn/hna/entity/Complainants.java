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
@Table(name = "Complainants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complainants.findAll", query = "SELECT c FROM Complainants c"),
    @NamedQuery(name = "Complainants.findByCplnID", query = "SELECT c FROM Complainants c WHERE c.cplnID = :cplnID"),
    @NamedQuery(name = "Complainants.findByFullName", query = "SELECT c FROM Complainants c WHERE c.fullName = :fullName"),
    @NamedQuery(name = "Complainants.findByIdentityCard", query = "SELECT c FROM Complainants c WHERE c.identityCard = :identityCard"),
    @NamedQuery(name = "Complainants.findByPassportNo", query = "SELECT c FROM Complainants c WHERE c.passportNo = :passportNo"),
    @NamedQuery(name = "Complainants.findByNationality", query = "SELECT c FROM Complainants c WHERE c.nationality = :nationality"),
    @NamedQuery(name = "Complainants.findByGender", query = "SELECT c FROM Complainants c WHERE c.gender = :gender"),
    @NamedQuery(name = "Complainants.findByBirthday", query = "SELECT c FROM Complainants c WHERE c.birthday = :birthday"),
    @NamedQuery(name = "Complainants.findByOccupation", query = "SELECT c FROM Complainants c WHERE c.occupation = :occupation"),
    @NamedQuery(name = "Complainants.findByPhone", query = "SELECT c FROM Complainants c WHERE c.phone = :phone"),
    @NamedQuery(name = "Complainants.findByEmail", query = "SELECT c FROM Complainants c WHERE c.email = :email"),
    @NamedQuery(name = "Complainants.findByAddress", query = "SELECT c FROM Complainants c WHERE c.address = :address"),
    @NamedQuery(name = "Complainants.findByRelativeName", query = "SELECT c FROM Complainants c WHERE c.relativeName = :relativeName")})
public class Complainants implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CplnID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer cplnID;
    @Basic(optional = false)
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "IdentityCard")
    private String identityCard;
    @Column(name = "PassportNo")
    private String passportNo;
    @Basic(optional = false)
    @Column(name = "Nationality")
    private String nationality;
    @Basic(optional = false)
    @Column(name = "Gender")
    private short gender;
    @Basic(optional = false)
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(name = "Occupation")
    private String occupation;
    @Basic(optional = false)
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Column(name = "RelativeName")
    private String relativeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complnID")
    private List<FIRs> fIRsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complnID")
    private List<Complaints> complaintsList;

    public Complainants() {
    }

    public Complainants(Integer cplnID) {
        this.cplnID = cplnID;
    }

    public Complainants(Integer cplnID, String fullName, String nationality, short gender, Date birthday, String phone, String address) {
        this.cplnID = cplnID;
        this.fullName = fullName;
        this.nationality = nationality;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
    }

    public Integer getCplnID() {
        return cplnID;
    }

    public void setCplnID(Integer cplnID) {
        this.cplnID = cplnID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    @XmlTransient
    public List<FIRs> getFIRsList() {
        return fIRsList;
    }

    public void setFIRsList(List<FIRs> fIRsList) {
        this.fIRsList = fIRsList;
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
        hash += (cplnID != null ? cplnID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complainants)) {
            return false;
        }
        Complainants other = (Complainants) object;
        if ((this.cplnID == null && other.cplnID != null) || (this.cplnID != null && !this.cplnID.equals(other.cplnID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Complainants[ cplnID=" + cplnID + " ]";
    }
    
}
