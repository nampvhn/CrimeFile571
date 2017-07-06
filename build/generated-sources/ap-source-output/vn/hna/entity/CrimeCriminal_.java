package vn.hna.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.CrimeTypes;
import vn.hna.entity.Criminals;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(CrimeCriminal.class)
public class CrimeCriminal_ { 

    public static volatile SingularAttribute<CrimeCriminal, Integer> crimeID;
    public static volatile SingularAttribute<CrimeCriminal, Criminals> criminalID;
    public static volatile SingularAttribute<CrimeCriminal, CrimeTypes> crimeTypeID;

}