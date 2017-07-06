package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Criminals;
import vn.hna.entity.Prisons;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Prisoners.class)
public class Prisoners_ { 

    public static volatile SingularAttribute<Prisoners, Criminals> criminalID;
    public static volatile SingularAttribute<Prisoners, Integer> prisonerID;
    public static volatile SingularAttribute<Prisoners, Prisons> prisonID;
    public static volatile SingularAttribute<Prisoners, Date> startTime;
    public static volatile SingularAttribute<Prisoners, Date> endTime;
    public static volatile SingularAttribute<Prisoners, String> timeInPrison;

}