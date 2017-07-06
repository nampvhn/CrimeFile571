package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.CaseCriminal;
import vn.hna.entity.Users;
import vn.hna.entity.Victims;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(CaseRecords.class)
public class CaseRecords_ { 

    public static volatile SingularAttribute<CaseRecords, String> crName;
    public static volatile SingularAttribute<CaseRecords, Date> lastUpdated;
    public static volatile SingularAttribute<CaseRecords, Integer> crID;
    public static volatile SingularAttribute<CaseRecords, String> motive;
    public static volatile SingularAttribute<CaseRecords, String> evidence;
    public static volatile SingularAttribute<CaseRecords, String> description;
    public static volatile ListAttribute<CaseRecords, Victims> victimsList;
    public static volatile SingularAttribute<CaseRecords, String> placeOfIncident;
    public static volatile ListAttribute<CaseRecords, CaseCriminal> caseCriminalList;
    public static volatile SingularAttribute<CaseRecords, Users> userID;
    public static volatile SingularAttribute<CaseRecords, Date> dateOfIncident;

}