/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.test;

import java.sql.Date;
import vn.hna.db.CriminalsDB;
import vn.hna.db.FIRsDB;
import vn.hna.db.RolesDB;
import vn.hna.db.UsersDB;

/**
 *
 * @author Edison
 */
public class Test {
    public static void main(String[] args) {
        RolesDB r = new RolesDB();
        UsersDB u = new UsersDB();
        FIRsDB c = new FIRsDB();
        CriminalsDB cri = new CriminalsDB();
//        List<Roles> list = r.viewRoles();
//        if (!list.isEmpty()) {
//            for (Roles role : list) {
//                System.out.println(role.getRoleName());
//            }
//        }
        //System.out.println(r.getRoleByID(1));
//        List<Users> list = u.login("admin", "admin");
//        if (!list.isEmpty()) {
//            for (Users user : list) {
//                System.out.println(user.getRoleID());
//            }
//        }
        //System.out.println(c.numOfNewFIR());
        
    }
}
