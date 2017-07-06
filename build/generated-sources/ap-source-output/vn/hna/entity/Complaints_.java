package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Complainants;
import vn.hna.entity.ComplaintTypes;
import vn.hna.entity.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Complaints.class)
public class Complaints_ { 

    public static volatile SingularAttribute<Complaints, Date> createdDate;
    public static volatile SingularAttribute<Complaints, ComplaintTypes> cplTypeID;
    public static volatile SingularAttribute<Complaints, Integer> compID;
    public static volatile SingularAttribute<Complaints, String> description;
    public static volatile SingularAttribute<Complaints, Complainants> complnID;
    public static volatile SingularAttribute<Complaints, Users> userID;
    public static volatile SingularAttribute<Complaints, Short> status;

}