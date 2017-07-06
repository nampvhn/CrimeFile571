package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.CaseRecords;
import vn.hna.entity.Postmortems;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Victims.class)
public class Victims_ { 

    public static volatile SingularAttribute<Victims, Date> birthday;
    public static volatile SingularAttribute<Victims, String> relativeName;
    public static volatile SingularAttribute<Victims, String> address;
    public static volatile SingularAttribute<Victims, Short> gender;
    public static volatile SingularAttribute<Victims, CaseRecords> crID;
    public static volatile SingularAttribute<Victims, String> fullName;
    public static volatile SingularAttribute<Victims, String> description;
    public static volatile ListAttribute<Victims, Postmortems> postmortemsList;
    public static volatile SingularAttribute<Victims, Integer> victimID;
    public static volatile SingularAttribute<Victims, Boolean> isDead;

}