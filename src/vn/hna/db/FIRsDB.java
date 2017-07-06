/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.db;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import vn.hna.entity.Areas;
import vn.hna.entity.Complaints;
import vn.hna.entity.Criminals;
import vn.hna.entity.FIRs;
import vn.hna.entity.Roles;

/**
 *
 * @author Edison
 */
public class FIRsDB {
    public long numOfNewFIR() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        long num = 0;

        try {
            entr.begin();
            
            String jpaQuery = "SELECT COUNT(f) FROM FIRs f WHERE f.status = 1";
            Query q = em.createQuery(jpaQuery, FIRs.class);
            num = (long) q.getSingleResult();
            
            entr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entr.isActive()) {
                entr.rollback();
            }
            DBFactory.closeDB();
        }
        return num;
    }
    
    public List<FIRs> viewFIRs() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<FIRs> list = null;
        try {
            entr.begin();

            Query q = em.createNamedQuery("FIRs.findAll");
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
    
    public boolean delete(int id) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            FIRs entity = em.find(FIRs.class, id);
            em.remove(id);
            em.flush();
            
            entr.commit();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (entr.isActive()) {
                entr.rollback();
            }
            DBFactory.closeDB();
        }
    }
    
    
}
