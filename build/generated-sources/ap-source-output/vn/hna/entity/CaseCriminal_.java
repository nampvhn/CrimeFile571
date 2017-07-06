package vn.hna.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.CaseRecords;
import vn.hna.entity.Criminals;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(CaseCriminal.class)
public class CaseCriminal_ { 

    public static volatile SingularAttribute<CaseCriminal, CaseRecords> crID;
    public static volatile SingularAttribute<CaseCriminal, Integer> ccID;
    public static volatile SingularAttribute<CaseCriminal, Criminals> criminalID;

}