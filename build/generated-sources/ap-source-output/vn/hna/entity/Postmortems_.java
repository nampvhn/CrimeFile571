package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Victims;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Postmortems.class)
public class Postmortems_ { 

    public static volatile SingularAttribute<Postmortems, String> reason;
    public static volatile SingularAttribute<Postmortems, String> doctorName;
    public static volatile SingularAttribute<Postmortems, Date> dateOfReport;
    public static volatile SingularAttribute<Postmortems, Date> dateOfDeath;
    public static volatile SingularAttribute<Postmortems, Integer> postmortemID;
    public static volatile SingularAttribute<Postmortems, String> description;
    public static volatile SingularAttribute<Postmortems, String> hospitalName;
    public static volatile SingularAttribute<Postmortems, Victims> victimID;

}