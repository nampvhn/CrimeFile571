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
import vn.hna.entity.CaseRecords;
import vn.hna.entity.Roles;

/**
 *
 * @author Edison
 */
public class CaseRecordsDB {
    public List<CaseRecords> viewCaseRecords() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<CaseRecords> list = null;
        try {
            entr.begin();

            Query q = em.createNamedQuery("CaseRecords.findAll");
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
            
            CaseRecords entity = em.find(CaseRecords.class, id);
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
