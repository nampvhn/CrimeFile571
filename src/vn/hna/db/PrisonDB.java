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
import vn.hna.entity.Prisons;
import vn.hna.entity.Roles;

/**
 *
 * @author Edison
 */
public class PrisonDB {

    public List<Prisons> viewPrisons() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<Prisons> list = null;
        try {
            entr.begin();

            Query q = em.createNamedQuery("Prisons.findAll");
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

    // Ko cần thiết sử dụng func này
    public String getRoleByID(int roleID) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        String roleName = "";
        try {
            entr.begin();
            
            Roles role = em.find(Roles.class, roleID);
            roleName = role.getRoleName();
            
            entr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entr.isActive()) {
                entr.rollback();
            }
            DBFactory.closeDB();
        }
        return roleName;
    }
    
    public boolean checkRoleName(String roleName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        List<Roles> list = null;

        try {
            entr.begin();
            
            String jpaQuery = "SELECT r FROM Roles r WHERE r.roleName = :roleName";
            Query q = em.createQuery(jpaQuery, Roles.class);
            q.setParameter("roleName", roleName);
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
    
    public boolean insert(String roleName, String desc) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Roles role = new Roles();
            role.setRoleName(roleName);
            role.setDescription(desc);
            role.setStatus((short) 1);
            em.persist(role);
            
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
    
    public boolean delete(int roleID) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Prisons role = em.find(Prisons.class, roleID);
            em.remove(role);
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
    
    public boolean update(int roleID, String roleName, String desc, short status) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Roles role = em.find(Roles.class, roleID);
            role.setRoleName(roleName);
            role.setDescription(desc);
            role.setStatus(status);
            em.merge(role);
            
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
    
    public Roles getRoleByName(String roleName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        
        Roles role = new Roles();
        try {
            entr.begin();
            
            String jpaQuery = "SELECT a.roleID FROM Roles a WHERE a.roleName = :roleName";
            Query q = em.createQuery(jpaQuery, Roles.class);
            q.setParameter("roleName", roleName);
            int id = (int) q.getSingleResult();
            
            role = em.find(Roles.class, id);
            
            entr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entr.isActive()) {
                entr.rollback();
            }
            DBFactory.closeDB();
        }
        return role;
    }
}
