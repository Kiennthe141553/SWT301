
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Doctor {
    private int id;
    private String name;
    private String dob;
    private String specialization;
    private int state;
    private String email;
    private String phone;

    public Doctor() {
    }

    public Doctor(int id, String name, String dob, String specialization, int state, String email, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.specialization = specialization;
        this.state = state;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String statename() {
        String statename = "";
        switch (state) {
            case 0:
                statename = "Vacation";
                break;
            case 1:
                statename = "Available";
                break;
            case 2:
                statename = "Busy in emergency";
                break;
            case 3:
                statename = "Diagnosing case";
                break;
        }
        return statename;
    }

    @Override
    public String toString() {
        String out = id+","+name+","+dob+","+specialization+","+statename()+","+email+","+phone;
        return out;
    }
    
    
}
