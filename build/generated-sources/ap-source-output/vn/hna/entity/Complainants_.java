package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Complaints;
import vn.hna.entity.FIRs;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Complainants.class)
public class Complainants_ { 

    public static volatile SingularAttribute<Complainants, String> passportNo;
    public static volatile SingularAttribute<Complainants, Date> birthday;
    public static volatile SingularAttribute<Complainants, String> occupation;
    public static volatile SingularAttribute<Complainants, String> address;
    public static volatile SingularAttribute<Complainants, Short> gender;
    public static volatile ListAttribute<Complainants, Complaints> complaintsList;
    public static volatile SingularAttribute<Complainants, Integer> cplnID;
    public static volatile ListAttribute<Complainants, FIRs> fIRsList;
    public static volatile SingularAttribute<Complainants, String> fullName;
    public static volatile SingularAttribute<Complainants, String> identityCard;
    public static volatile SingularAttribute<Complainants, String> relativeName;
    public static volatile SingularAttribute<Complainants, String> nationality;
    public static volatile SingularAttribute<Complainants, String> phone;
    public static volatile SingularAttribute<Complainants, String> email;

}