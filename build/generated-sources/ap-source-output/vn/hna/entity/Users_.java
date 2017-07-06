package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.CaseRecords;
import vn.hna.entity.Complaints;
import vn.hna.entity.FIRs;
import vn.hna.entity.Roles;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Date> birthday;
    public static volatile SingularAttribute<Users, String> image;
    public static volatile SingularAttribute<Users, Date> lastLogin;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, Short> gender;
    public static volatile ListAttribute<Users, Complaints> complaintsList;
    public static volatile ListAttribute<Users, FIRs> fIRsList;
    public static volatile SingularAttribute<Users, Roles> roleID;
    public static volatile SingularAttribute<Users, String> fullName;
    public static volatile SingularAttribute<Users, Integer> userID;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile SingularAttribute<Users, String> rank;
    public static volatile ListAttribute<Users, CaseRecords> caseRecordsList;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, Short> status;

}