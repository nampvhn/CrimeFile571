package vn.hna.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.CrimeCriminal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(CrimeTypes.class)
public class CrimeTypes_ { 

    public static volatile ListAttribute<CrimeTypes, CrimeCriminal> crimeCriminalList;
    public static volatile SingularAttribute<CrimeTypes, Integer> crimeTypeID;
    public static volatile SingularAttribute<CrimeTypes, String> crimeTypeName;
    public static volatile SingularAttribute<CrimeTypes, String> description;

}