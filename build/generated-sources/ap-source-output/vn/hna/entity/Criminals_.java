package vn.hna.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Areas;
import vn.hna.entity.CaseCriminal;
import vn.hna.entity.CrimeCriminal;
import vn.hna.entity.Prisoners;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Criminals.class)
public class Criminals_ { 

    public static volatile SingularAttribute<Criminals, Date> birthday;
    public static volatile SingularAttribute<Criminals, String> occupation;
    public static volatile SingularAttribute<Criminals, Short> gender;
    public static volatile ListAttribute<Criminals, Prisoners> prisonersList;
    public static volatile SingularAttribute<Criminals, String> description;
    public static volatile SingularAttribute<Criminals, Boolean> isPrisonner;
    public static volatile SingularAttribute<Criminals, String> mental;
    public static volatile SingularAttribute<Criminals, Boolean> isMostWanted;
    public static volatile SingularAttribute<Criminals, Areas> areaID;
    public static volatile SingularAttribute<Criminals, Integer> criminalID;
    public static volatile SingularAttribute<Criminals, String> fingerprint;
    public static volatile SingularAttribute<Criminals, String> permanentAddress;
    public static volatile SingularAttribute<Criminals, String> passportNo;
    public static volatile SingularAttribute<Criminals, String> image3;
    public static volatile SingularAttribute<Criminals, String> identificationMark;
    public static volatile SingularAttribute<Criminals, String> nickName;
    public static volatile SingularAttribute<Criminals, String> fullName;
    public static volatile SingularAttribute<Criminals, String> identityCard;
    public static volatile SingularAttribute<Criminals, String> image1;
    public static volatile SingularAttribute<Criminals, String> image2;
    public static volatile ListAttribute<Criminals, CaseCriminal> caseCriminalList;
    public static volatile SingularAttribute<Criminals, String> relativeName;
    public static volatile ListAttribute<Criminals, CrimeCriminal> crimeCriminalList;
    public static volatile SingularAttribute<Criminals, String> nationality;
    public static volatile SingularAttribute<Criminals, String> residentialAddress;

}