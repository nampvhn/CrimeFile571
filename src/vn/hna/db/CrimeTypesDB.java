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
import vn.hna.entity.CrimeTypes;
import vn.hna.entity.Roles;

/**
 *
 * @author Edison
 */
public class CrimeTypesDB {

    public List<CrimeTypes> viewCrimeTypes() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<CrimeTypes> list = null;
        try {
            entr.begin();

            Query q = em.createNamedQuery("CrimeTypes.findAll");
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
    
    public boolean checkCrimeTypeName(String crimeTypeName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        List<CrimeTypes> list = null;

        try {
            entr.begin();
            
            String jpaQuery = "SELECT ct FROM CrimeTypes ct WHERE ct.crimeTypeName = :crimeTypeName";
            Query q = em.createQuery(jpaQuery, CrimeTypes.class);
            q.setParameter("crimeTypeName", crimeTypeName);
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
    
    public boolean insert(String crimeTypeName, String desc) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            CrimeTypes crimeType = new CrimeTypes();
            crimeType.setCrimeTypeName(crimeTypeName);
            crimeType.setDescription(desc);
            em.persist(crimeType);
            
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
    
    public boolean delete(int crimeTypeID) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            CrimeTypes crimeType = em.find(CrimeTypes.class, crimeTypeID);
            em.remove(crimeType);
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
    
    public boolean update(int crimeTypeID, String crimeTypeName, String desc) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            CrimeTypes crimeType = em.find(CrimeTypes.class, crimeTypeID);
            crimeType.setCrimeTypeName(crimeTypeName);
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
