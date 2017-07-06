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
import vn.hna.entity.Areas;
import vn.hna.entity.Users;

/**
 *
 * @author Edison
 */
public class AreasDB {
    public List<Areas> viewAreas() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<Areas> list = null;
        try {
            entr.begin();

            Query q = em.createNamedQuery("Areas.findAll");
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
    
    public Areas getAreaByName(String areaName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        
        Areas area = new Areas();
        try {
            entr.begin();
            
            String jpaQuery = "SELECT a.areaID FROM Areas a WHERE a.areaName = :areaName";
            Query q = em.createQuery(jpaQuery, Areas.class);
            q.setParameter("areaName", areaName);
            int id = (int) q.getSingleResult();
            
            area = em.find(Areas.class, id);
            
            entr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entr.isActive()) {
                entr.rollback();
            }
            DBFactory.closeDB();
        }
        return area;
    }
    
    public boolean checkName(String areaName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        List<Areas> list = null;

        try {
            entr.begin();
            
            String jpaQuery = "SELECT r FROM Areas r WHERE r.areaName = :areaName";
            Query q = em.createQuery(jpaQuery, Areas.class);
            q.setParameter("areaName", areaName);
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
    
    public boolean insert(String areaName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Areas area = new Areas();
            area.setAreaName(areaName);
            em.persist(area);
            
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
    
    public boolean delete(int areaID) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Areas area = em.find(Areas.class, areaID);
            em.remove(area);
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
    
    public boolean update(int areaID, String areaName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Areas area = em.find(Areas.class, areaID);
            area.setAreaName(areaName);
            em.merge(area);
            
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
