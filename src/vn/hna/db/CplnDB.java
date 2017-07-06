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
import vn.hna.entity.Complainants;
import vn.hna.entity.Criminals;

/**
 *
 * @author Edison
 */
public class CplnDB {
    public List<Complainants> viewCplns() {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        List<Complainants> list = null;
        try {
            entr.begin();
            
            Query q = em.createNamedQuery("Complainants.findAll");
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
    
    public boolean insert(String fullName, String nickName, String idCard, String passportNo, String nationality, short gender, Date birthday, String idMark, String desc, String mental, String occupation, String resAddress, String perAddress, Areas area, String fgPrint, String img1, String img2, String img3, boolean isPrisoner, boolean isWanted, String relName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Criminals criminal = new Criminals();
            criminal.setFullName(fullName);
            criminal.setNickName(nickName);
            criminal.setIdentityCard(idCard);
            criminal.setPassportNo(passportNo);
            criminal.setNationality(nationality);
            criminal.setGender((gender));
            criminal.setBirthday(birthday);
            criminal.setIdentificationMark(idMark);
            criminal.setDescription(desc);
            criminal.setMental(mental);
            criminal.setOccupation(occupation);
            criminal.setResidentialAddress(resAddress);
            criminal.setPermanentAddress(perAddress);
            criminal.setAreaID(area);
            criminal.setFingerprint(fgPrint);
            criminal.setImage1(img1);
            criminal.setImage2(img2);
            criminal.setImage3(img3);
            criminal.setIsPrisonner(isPrisoner);
            criminal.setIsMostWanted(isWanted);
            criminal.setRelativeName(relName);
            
            em.persist(criminal);
            
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
    
    public boolean delete(int id) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Complainants entity = em.find(Complainants.class, id);
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
    
    public boolean update(int id, String fullName, String nickName, String idCard, String passportNo, String nationality, short gender, Date birthday, String idMark, String desc, String mental, String occupation, String resAddress, String perAddress, Areas area, String fgPrint, String img1, String img2, String img3, boolean isPrisoner, boolean isWanted, String relName) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        try {
            entr.begin();
            
            Criminals entity = em.find(Criminals.class, id);
            entity.setFullName(fullName);
            entity.setNickName(nickName);
            entity.setIdentityCard(idCard);
            entity.setPassportNo(passportNo);
            entity.setNationality(nationality);
            entity.setGender((gender));
            entity.setBirthday(birthday);
            entity.setIdentificationMark(idMark);
            entity.setDescription(desc);
            entity.setMental(mental);
            entity.setOccupation(occupation);
            entity.setResidentialAddress(resAddress);
            entity.setPermanentAddress(perAddress);
            entity.setAreaID(area);
            entity.setFingerprint(fgPrint);
            entity.setImage1(img1);
            entity.setImage2(img2);
            entity.setImage3(img3);
            entity.setIsPrisonner(isPrisoner);
            entity.setIsMostWanted(isWanted);
            entity.setRelativeName(relName);
            em.merge(entity);
            
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
    
    public Criminals getCriminalByID(int criminalID) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();

        Criminals criminal = null;
        try {
            entr.begin();

            criminal = em.find(Criminals.class, criminalID);

            entr.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entr.isActive()) {
                entr.rollback();
            }
            DBFactory.closeDB();
        }
        return criminal;
    }
    
    public List<Criminals> getMostWantedList(boolean isMostWanted) {
        EntityManager em = DBFactory.connectDB();
        EntityTransaction entr = em.getTransaction();
        
        List<Criminals> list = null;
        try {
            entr.begin();
            
            String jpaQuery = "SELECT c FROM Criminals c WHERE c.isMostWanted = :isMostWanted";
            Query q = em.createQuery(jpaQuery, Criminals.class);
            q.setParameter("isMostWanted", isMostWanted);
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
    
    public static void main(String[] args) {
        CriminalsDB db = new CriminalsDB();
        List<Criminals> l = db.getMostWantedList(true);
        for (Criminals c : l) {
            System.out.println(c.getFullName());
        }
    }
}
