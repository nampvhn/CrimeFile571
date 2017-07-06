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
import vn.hna.entity.Complaints;
import vn.hna.entity.Roles;
import static vn.hna.entity.Roles_.roleName;

/**
 *
 * @author Edison
 */
public class ComplaintsDB {
    public long numOfNewComplaint() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        long num = 0;

        try {
            entr.begin();
            
            String jpaQuery = "SELECT COUNT(c) FROM Complaints c WHERE c.status = 0";
            Query q = em.createQuery(jpaQuery, Complaints.class);
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
    
    public List<Complaints> viewComplaints() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<Complaints> list = null;
        try {
            entr.begin();

            Query q = em.createNamedQuery("Complaints.findAll");
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
            
            Complaints entity = em.find(Complaints.class, id);
            em.remove(entity);
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
