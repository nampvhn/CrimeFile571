/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Edison
 */
public abstract class DBFactory {
    static EntityManagerFactory emf;
    static EntityManager em;
    
    public static EntityManager connectDB() {
        try {
            emf = Persistence.createEntityManagerFactory("CrimeFile571PU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return em;
    }
    
    public static void closeDB() {
        try {
            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
