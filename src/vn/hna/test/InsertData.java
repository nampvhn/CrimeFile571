/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.test;

import java.sql.Date;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import vn.hna.db.CriminalsDB;
import vn.hna.entity.Areas;
import vn.hna.entity.Criminals;

/**
 *
 * @author Edison
 */
public class InsertData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimeFile571PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entr = em.getTransaction();

        CriminalsDB c = new CriminalsDB();
        try {
            entr.begin();

            Areas a = em.find(Areas.class, 1);
            
            for (int i = 10; i < 100; i++) { 
                c.insert("Nguyen Van A" + i, null, "1112223" + i, null, "Vietnamese", (short) 1, Date.valueOf(1900 + i + "-09-09"), "Boss-eyes", null, null, null, "House " + i, "House " + i, a, null, null, null, null, false, false, null);
            }

            entr.commit();

        } finally {
            if (entr.isActive()) {
                entr.rollback();
            }
            em.close();
            emf.close();
        }
    }
}
