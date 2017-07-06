/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edison
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserID", query = "SELECT u FROM Users u WHERE u.userID = :userID"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByFullName", query = "SELECT u FROM Users u WHERE u.fullName = :fullName"),
    @NamedQuery(name = "Users.findByRank", query = "SELECT u FROM Users u WHERE u.rank = :rank"),
    @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender"),
    @NamedQuery(name = "Users.findByBirthday", query = "SELECT u FROM Users u WHERE u.birthday = :birthday"),
    @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByAddress", query = "SELECT u FROM Users u WHERE u.address = :address"),
    @NamedQuery(name = "Users.findByImage", query = "SELECT u FROM Users u WHERE u.image = :image"),
    @NamedQuery(name = "Users.findByLastLogin", query = "SELECT u FROM Users u WHERE u.lastLogin = :lastLogin"),
    @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status")})
public class Users implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userID;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Rank")
    private String rank;
    @Column(name = "Gender")
    private Short gender;
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Address")
    private String address;
    @Column(name = "Image")
    private String image;
    @Column(name = "LastLogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Basic(optional = false)
    @Column(name = "Status")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private List<FIRs> fIRsList;
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    @ManyToOne(optional = false)
    private Roles roleID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private List<CaseRecords> caseRecordsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private List<Complaints> complaintsList;

    public Users() {
    }

    public Users(Integer userID) {
        this.userID = userID;
    }

    public Users(Integer userID, String username, String password, String fullName, short status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        Integer oldUserID = this.userID;
        this.userID = userID;
        changeSupport.firePropertyChange("userID", oldUserID, userID);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        String oldFullName = this.fullName;
        this.fullName = fullName;
        changeSupport.firePropertyChange("fullName", oldFullName, fullName);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        String oldRank = this.rank;
        this.rank = rank;
        changeSupport.firePropertyChange("rank", oldRank, rank);
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        Short oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        Date oldBirthday = this.birthday;
        this.birthday = birthday;
        changeSupport.firePropertyChange("birthday", oldBirthday, birthday);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        String oldImage = this.image;
        this.image = image;
        changeSupport.firePropertyChange("image", oldImage, image);
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        Date oldLastLogin = this.lastLogin;
        this.lastLogin = lastLogin;
        changeSupport.firePropertyChange("lastLogin", oldLastLogin, lastLogin);
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        short oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    @XmlTransient
    public List<FIRs> getFIRsList() {
        return fIRsList;
    }

    public void setFIRsList(List<FIRs> fIRsList) {
        this.fIRsList = fIRsList;
    }

    public Roles getRoleID() {
        return roleID;
    }

    public void setRoleID(Roles roleID) {
        Roles oldRoleID = this.roleID;
        this.roleID = roleID;
        changeSupport.firePropertyChange("roleID", oldRoleID, roleID);
    }

    @XmlTransient
    public List<CaseRecords> getCaseRecordsList() {
        return caseRecordsList;
    }

    public void setCaseRecordsList(List<CaseRecords> caseRecordsList) {
        this.caseRecordsList = caseRecordsList;
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
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hna.entity.Users[ userID=" + userID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
