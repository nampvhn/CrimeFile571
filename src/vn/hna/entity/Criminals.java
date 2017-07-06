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
@Table(name = "Criminals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criminals.findAll", query = "SELECT c FROM Criminals c"),
    @NamedQuery(name = "Criminals.findByCriminalID", query = "SELECT c FROM Criminals c WHERE c.criminalID = :criminalID"),
    @NamedQuery(name = "Criminals.findByFullName", query = "SELECT c FROM Criminals c WHERE c.fullName = :fullName"),
    @NamedQuery(name = "Criminals.findByNickName", query = "SELECT c FROM Criminals c WHERE c.nickName = :nickName"),
    @NamedQuery(name = "Criminals.findByIdentityCard", query = "SELECT c FROM Criminals c WHERE c.identityCard = :identityCard"),
    @NamedQuery(name = "Criminals.findByPassportNo", query = "SELECT c FROM Criminals c WHERE c.passportNo = :passportNo"),
    @NamedQuery(name = "Criminals.findByNationality", query = "SELECT c FROM Criminals c WHERE c.nationality = :nationality"),
    @NamedQuery(name = "Criminals.findByGender", query = "SELECT c FROM Criminals c WHERE c.gender = :gender"),
    @NamedQuery(name = "Criminals.findByBirthday", query = "SELECT c FROM Criminals c WHERE c.birthday = :birthday"),
    @NamedQuery(name = "Criminals.findByIdentificationMark", query = "SELECT c FROM Criminals c WHERE c.identificationMark = :identificationMark"),
    @NamedQuery(name = "Criminals.findByDescription", query = "SELECT c FROM Criminals c WHERE c.description = :description"),
    @NamedQuery(name = "Criminals.findByMental", query = "SELECT c FROM Criminals c WHERE c.mental = :mental"),
    @NamedQuery(name = "Criminals.findByOccupation", query = "SELECT c FROM Criminals c WHERE c.occupation = :occupation"),
    @NamedQuery(name = "Criminals.findByResidentialAddress", query = "SELECT c FROM Criminals c WHERE c.residentialAddress = :residentialAddress"),
    @NamedQuery(name = "Criminals.findByPermanentAddress", query = "SELECT c FROM Criminals c WHERE c.permanentAddress = :permanentAddress"),
    @NamedQuery(name = "Criminals.findByFingerprint", query = "SELECT c FROM Criminals c WHERE c.fingerprint = :fingerprint"),
    @NamedQuery(name = "Criminals.findByImage1", query = "SELECT c FROM Criminals c WHERE c.image1 = :image1"),
    @NamedQuery(name = "Criminals.findByImage2", query = "SELECT c FROM Criminals c WHERE c.image2 = :image2"),
    @NamedQuery(name = "Criminals.findByImage3", query = "SELECT c FROM Criminals c WHERE c.image3 = :image3"),
    @NamedQuery(name = "Criminals.findByIsPrisonner", query = "SELECT c FROM Criminals c WHERE c.isPrisonner = :isPrisonner"),
    @NamedQuery(name = "Criminals.findByIsMostWanted", query = "SELECT c FROM Criminals c WHERE c.isMostWanted = :isMostWanted"),
    @NamedQuery(name = "Criminals.findByRelativeName", query = "SELECT c FROM Criminals c WHERE c.relativeName = :relativeName")})
public class Criminals implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CriminalID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer criminalID;
    @Basic(optional = false)
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "NickName")
    private String nickName;
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
    @Basic(optional = false)
    @Column(name = "IdentificationMark")
    private String identificationMark;
    @Column(name = "Description")
    private String description;
    @Column(name = "Mental")
    private String mental;
    @Column(name = "Occupation")
    private String occupation;
    @Basic(optional = false)
    @Column(name = "ResidentialAddress")
    private String residentialAddress;
    @Basic(optional = false)
    @Column(name = "PermanentAddress")
    private String permanentAddress;
    @Column(name = "Fingerprint")
    private String fingerprint;
    @Column(name = "Image1")
    private String image1;
    @Column(name = "Image2")
    private String image2;
    @Column(name = "Image3")
    private String image3;
    @Column(name = "IsPrisonner")
    private Boolean isPrisonner;
    @Column(name = "IsMostWanted")
    private Boolean isMostWanted;
    @Column(name = "RelativeName")
    private String relativeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criminalID")
    private List<CaseCriminal> caseCriminalList;
    @JoinColumn(name = "AreaID", referencedColumnName = "AreaID")
    @ManyToOne(optional = false)
    private Areas areaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criminalID")
    private List<CrimeCriminal> crimeCriminalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criminalID")
    private List<Prisoners> prisonersList;

    public Criminals() {
    }

    public Criminals(Integer criminalID) {
        this.criminalID = criminalID;
    }

    public Criminals(Integer criminalID, String fullName, String nationality, short gender, Date birthday, String identificationMark, String residentialAddress, String permanentAddress) {
        this.criminalID = criminalID;
        this.fullName = fullName;
        this.nationality = nationality;
        this.gender = gender;
        this.birthday = birthday;
        this.identificationMark = identificationMark;
        this.residentialAddress = residentialAddress;
        this.permanentAddress = permanentAddress;
    }

    public Integer getCriminalID() {
        return criminalID;
    }

    public void setCriminalID(Integer criminalID) {
        this.criminalID = criminalID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getIdentificationMark() {
        return identificationMark;
    }

    public void setIdentificationMark(String identificationMark) {
        this.identificationMark = identificationMark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMental() {
        return mental;
    }

    public void setMental(String mental) {
        this.mental = mental;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public Boolean getIsPrisonner() {
        return isPrisonner;
    }

    public void setIsPrisonner(Boolean isPrisonner) {
        this.isPrisonner = isPrisonner;
    }

    public Boolean getIsMostWanted() {
        return isMostWanted;
    }

    public void setIsMostWanted(Boolean isMostWanted) {
        this.isMostWanted = isMostWanted;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    @XmlTransient
    public List<CaseCriminal> getCaseCriminalList() {
        return caseCriminalList;
    }

    public void setCaseCriminalList(List<CaseCriminal> caseCriminalList) {
        this.caseCriminalList = caseCriminalList;
    }

    public Areas getAreaID() {
        return areaID;
    }

    public void setAreaID(Areas areaID) {
        this.areaID = areaID;
    }

    @XmlTransient
    public List<CrimeCriminal> getCrimeCriminalList() {
        return crimeCriminalList;
    }

    public void setCrimeCriminalList(List<CrimeCriminal> crimeCriminalList) {
        this.crimeCriminalList = crimeCriminalList;
    }

    @XmlTransient
    public List<Prisoners> getPrisonersList() {
        return prisonersList;
    }

    public void setPrisonersList(List<Prisoners> prisonersList) {
        this.prisonersList = prisonersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criminalID != null ? criminalID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criminals)) {
            return false;
        }
        Criminals other = (Criminals) object;
        if ((this.criminalID == null && other.criminalID != null) || (this.criminalID != null && !this.criminalID.equals(other.criminalID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Criminals[ criminalID=" + criminalID + " ]";
    }
    
}
