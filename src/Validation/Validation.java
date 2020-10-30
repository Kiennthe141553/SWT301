/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Validation {
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static final String PHONE_REGEX = "\\b\\d{3}([-])\\d{3}\\1\\d{4}\\b";
    public static String getName(String str) throws Exception {
        try {
            if (str.length() < 0 || str.length() > 50) {
                throw new Exception("Name can not greater than 50 character!");
            }
            if (str.equals("")) {
                throw new Exception("Name can not empty!");
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getDob(String str) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date d = dateFormat.parse(str);
            return dateFormat.format(d);
        } catch (ParseException e) {
            throw new Exception("Date must in format dd/MM/yyyy!");
        }
    }

    public static int getState(String str) throws Exception {
        int integer;
        try{
            integer = Integer.parseInt(str);           
        }catch(Exception e){
            throw new Exception("Invalid state!");
        }
        if(integer <0 || integer > 3){
            throw new Exception("State range form 0-3!");
        }
        return integer;
    }

    public static String getSpec(String str) throws Exception {
        try {
            if (str.length() < 0 || str.length() > 255) {
                throw new Exception("Spec can not greater than 255 character!");
            }
            if (str.equals("")) {
                throw new Exception("Spec can not empty!");
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static int getID(String id) throws Exception {
        int integer;
        try{
            integer = Integer.parseInt(id);           
        }catch(Exception e){
            throw new Exception("Id must be an integer!");
        }
        return integer;
    }
    
    public static String getEmail(String str) throws Exception{
        try{
            if(!str.matches(EMAIL_REGEX)){
                throw new Exception("Enter email again!");
            }
            return str;
        }catch(Exception e){
            throw e;
        }
    }
    
    public static String getPhone(String str) throws Exception{
        try{
            if(!str.matches(PHONE_REGEX)){
                throw new Exception("Phone must in format 000-000-0000!");
            }
            return str;
        }catch(Exception e){
            throw e;
        }
    }
    
}
