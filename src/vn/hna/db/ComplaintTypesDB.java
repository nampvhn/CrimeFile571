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
import vn.hna.entity.ComplaintTypes;
import vn.hna.entity.CrimeTypes;

/**
 *
 * @author Edison
 */
public class ComplaintTypesDB {

    public List<ComplaintTypes> viewComplaintTypes() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<ComplaintTypes> list = null;
        try {
            entr.begin();

            Query q = em.createNamedQuery("ComplaintTypes.findAll");
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
    
    public boolean checkName(String cplTypeName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        List<ComplaintTypes> list = null;

        try {
            entr.begin();
            
            String jpaQuery = "SELECT ct FROM ComplaintTypes ct WHERE ct.cplTypeName = :cplTypeName";
            Query q = em.createQuery(jpaQuery, ComplaintTypes.class);
            q.setParameter("cplTypeName", cplTypeName);
            list = q.getResultList();
            
            entr.commit();
            
            if (!list.isEmpty()) {
                return true;
            } else {
                return false;
            }
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
    
    public boolean insert(String complaintTypeName, String desc) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            ComplaintTypes complaintType = new ComplaintTypes();
            complaintType.setCplTypeName(complaintTypeName);
            complaintType.setDescription(desc);
            em.persist(complaintType);
            
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
    
    public boolean delete(int cplTypeID) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            ComplaintTypes cplType = em.find(ComplaintTypes.class, cplTypeID);
            em.remove(cplType);
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
    
    public boolean update(int cplTypeID, String cplTypeName, String desc) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            ComplaintTypes crimeType = em.find(ComplaintTypes.class, cplTypeID);
            crimeType.setCplTypeName(cplTypeName);
            crimeType.setDescription(desc);
            em.merge(crimeType);
            
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
