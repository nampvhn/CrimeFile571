package vn.hna.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Prisoners;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Prisons.class)
public class Prisons_ { 

    public static volatile SingularAttribute<Prisons, String> address;
    public static volatile ListAttribute<Prisons, Prisoners> prisonersList;
    public static volatile SingularAttribute<Prisons, Integer> prisonID;
    public static volatile SingularAttribute<Prisons, String> prisonName;

}