/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Edison
 */
public class DateTools {
    public String formatedDate(Date date, String pattern) {
        String dateString = "";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            dateFormat.setLenient(false);
            dateString = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateString;
    }
    
    public Date convertStringToDate (String str, String pattern) {
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            dateFormat.setLenient(false);
            date = dateFormat.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public int calAge(String birthday) {
        int age = -1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        Calendar now = Calendar.getInstance();
        Calendar bir = Calendar.getInstance();
        try {
            bir.setTime(dateFormat.parse(birthday));
            age = now.get(Calendar.YEAR) - bir.get(Calendar.YEAR);
            if (now.get(Calendar.MONTH) < bir.get(Calendar.MONTH)) {
                age--;
            } 
            else if ((now.get(Calendar.MONTH) == bir.get(Calendar.MONTH)) && (now.get(Calendar.DAY_OF_MONTH) < bir.get(Calendar.DAY_OF_MONTH))) {
                age--;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return age;
    }
    
    public long getDateDistance(Date firstDate, Date secondDate) {
        long gap = 0;
        
        Calendar firstCal = Calendar.getInstance();
        firstCal.setTime(firstDate);
        Calendar secondCal = Calendar.getInstance();
        secondCal.setTime(secondDate);
        
        Calendar clone = (Calendar) firstCal.clone();
        while (clone.before(secondCal)) {
            clone.add(Calendar.DAY_OF_MONTH, 1);
            gap++;
        }
        
        return gap;
    }
    
    public String convertDateToString(Date date) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTimeInMillis(date.getTime());
            int d = cal.get(Calendar.DAY_OF_MONTH);
            int m = cal.get(Calendar.MONTH) + 1;
            int yyyy = cal.get(Calendar.YEAR);
            String dd = (d < 10) ? "0" + d : "" + d;
            String MM = (m < 10) ? "0" + m : "" + m;
            return dd + "/" + MM + "/" + yyyy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        DateTools dt = new DateTools();
        System.out.println(dt.formatedDate(new Date(), "yyyy-MM-dd hh:mm"));
        Date d = dt.convertStringToDate("27-12-1989", "dd-MM-yyyy");
        System.out.println(dt.formatedDate(d, "dd-MM-yyyy"));
    }
}
