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
import vn.hna.entity.CaseCriminal;
import vn.hna.entity.Roles;

/**
 *
 * @author Edison
 */
public class CaseCriminalDB {
    public List<CaseCriminal> viewCaseCriminal() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<CaseCriminal> list = null;
        try {
            entr.begin();

            Query q = em.createNamedQuery("CaseCriminal.findAll");
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
}
