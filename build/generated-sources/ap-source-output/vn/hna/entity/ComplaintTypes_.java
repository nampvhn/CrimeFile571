package vn.hna.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Complaints;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(ComplaintTypes.class)
public class ComplaintTypes_ { 

    public static volatile SingularAttribute<ComplaintTypes, Integer> cplTypeID;
    public static volatile ListAttribute<ComplaintTypes, Complaints> complaintsList;
    public static volatile SingularAttribute<ComplaintTypes, String> description;
    public static volatile SingularAttribute<ComplaintTypes, String> cplTypeName;

}