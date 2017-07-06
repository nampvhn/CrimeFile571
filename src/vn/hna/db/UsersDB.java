/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.db;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import vn.hna.entity.Areas;
import vn.hna.entity.Criminals;
import vn.hna.entity.Roles;
import vn.hna.entity.Users;

/**
 *
 * @author Edison
 */
public class UsersDB {
    public List<Users> viewUsers() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        
        List<Users> list = null;
        try {
            entr.begin();
            
            Query q = em.createNamedQuery("Users.findAll");
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
    
    public List<Users> login(String username, String password) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        
        List<Users> list = null;
        try {
            entr.begin();
            
            //String jpaQuery = "SELECT u, r FROM Users u INNER JOIN u.roleID r WHERE u.username = :username AND u.password = :password";
            String jpaQuery = "SELECT u FROM Users u WHERE u.username = :username AND u.password = :password AND u.status = :status";
            Query q = em.createQuery(jpaQuery, Users.class);
            q.setParameter("username", username);
            q.setParameter("password", password);
            q.setParameter("status", 1);
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
    
    public boolean delete(int userID) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Users user = em.find(Users.class, userID);
            em.remove(user);
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
    
    public boolean insert(Roles roleID, String username, String password, String fullName, String rank, short gender, Date birthday, String phone, String email, String address, String img, Date lastLogin) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Users user = new Users();
            user.setRoleID(roleID);
            user.setUsername(username);
            user.setPassword(password);;
            user.setFullName(fullName);
            user.setRank(rank);
            user.setBirthday(birthday);
            user.setPhone(phone);
            user.setEmail(email);
            user.setAddress(address);
            user.setImage(img);
            user.setLastLogin(lastLogin);
            user.setStatus((short) 1);
            
            em.persist(user);
            
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
