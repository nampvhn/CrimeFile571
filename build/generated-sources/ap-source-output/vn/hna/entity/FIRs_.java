package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Complainants;
import vn.hna.entity.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(FIRs.class)
public class FIRs_ { 

    public static volatile SingularAttribute<FIRs, String> reasonDelay;
    public static volatile SingularAttribute<FIRs, Date> createdDate;
    public static volatile SingularAttribute<FIRs, Integer> firID;
    public static volatile SingularAttribute<FIRs, String> description;
    public static volatile SingularAttribute<FIRs, Complainants> complnID;
    public static volatile SingularAttribute<FIRs, String> placeOfIncident;
    public static volatile SingularAttribute<FIRs, Users> userID;
    public static volatile SingularAttribute<FIRs, Date> dateOfIncident;
    public static volatile SingularAttribute<FIRs, Short> status;

}