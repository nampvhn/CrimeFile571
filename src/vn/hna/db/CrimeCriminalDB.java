/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import vn.hna.entity.CrimeCriminal;
import vn.hna.entity.Criminals;
import vn.hna.entity.Roles;

/**
 *
 * @author Edison
 */
public class CrimeCriminalDB {

    public List<CrimeCriminal> getCrimeTypesByCriminalID(Criminals criminalID) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<CrimeCriminal> list = null;
        try {
            entr.begin();

            String jpaQuery = "SELECT cc FROM CrimeCriminal cc WHERE cc.criminalID = :criminalID";
            Query q = em.createQuery(jpaQuery, CrimeCriminal.class);
            q.setParameter("criminalID", criminalID);
            list = q.getResultList();

            entr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entr.isActive()) {
                entr.rollback();
            }
            DBFactory.closeDB();
        }
        return list;
    }
    
    public static void main(String[] args) {
        CrimeCriminalDB db = new CrimeCriminalDB();
        CriminalsDB c = new CriminalsDB();
        List<CrimeCriminal> l = db.getCrimeTypesByCriminalID(c.getCriminalByID(73));
        String s = "";
        for (CrimeCriminal cc : l) {
            s += cc.getCrimeTypeID().getCrimeTypeName() + ", ";
        }
        System.out.print(s.substring(0, s.length()-2));
        
        
        Criminals cr = c.getCriminalByID(73);
        cr.getCrimeCriminalList();
    }
}
