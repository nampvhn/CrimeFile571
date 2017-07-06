package vn.hna.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vn.hna.entity.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:30:37")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile ListAttribute<Roles, Users> usersList;
    public static volatile SingularAttribute<Roles, Integer> roleID;
    public static volatile SingularAttribute<Roles, String> roleName;
    public static volatile SingularAttribute<Roles, String> description;
    public static volatile SingularAttribute<Roles, Short> status;

}