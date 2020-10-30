
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class Management {

    ArrayList<Doctor> list = new ArrayList<>();
    Input v = new Input();

    public void addDoctor() throws Exception {
        int id;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
        }
        String name = v.getName("Enter doctor name:");
        String dob = v.getDob("Enter dob:");
        String spec = v.getSpec("Enter specialization:");
        int state = v.getState("Enter doctor state:");
        String email = v.getEmail("Enter email: ");
        String phone = v.getPhone("Enter phone: ");
        Doctor d = new Doctor(id, name, dob, spec, state, email, phone);
        list.add(d);
    }

    public void getName() {
        String name = v.getName("Enter doctor name:");
    }

    public String editInfo(int id) throws Exception {
        int check = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                check = 1;
                list.get(i).setName(v.getName("Enter doctor name:"));
                list.get(i).setDob(v.getDob("Enter dob:"));
                list.get(i).setSpecialization(v.getSpec("Enter specialization:"));
                list.get(i).setState(v.getState("Enter doctor state:"));
                list.get(i).setEmail(v.getEmail("Enter doctor email:"));
                list.get(i).setPhone(v.getPhone("Enter phone:"));
            }
        }
        if (check == 1) {
            return "Update successful!";
        } else {
            return "ID not found!";
        }
    }

    public String deleteDoctor(int id) {
        boolean check = false;
        if (list.isEmpty()) {
            return "The list is empty!";
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    check = true;
                    list.remove(i);
                }
            }

        }
        if (check == true) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setId(i + 1);
            }
            return "Delete successfully!";
        } else {
            return "ID not found!";
        }
    }

    public String searchID(int id) {
        int check = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                check = 1;
                return list.get(i).toString();
            }
        }
        if (check != 1) {
            return "Not Found!";
        }
        return "";
    }

    public String searchName(String name) {
        int check = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                check = 1;
                return list.get(i).toString();
            }
        }
        if (check != 1) {
            return "Not Found!";
        }
        return "";
    }

    public void sortByDob() {
        Collections.sort(list, new Comparator<Doctor>() {
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

            @Override
            public int compare(Doctor o1, Doctor o2) {
                try {
                    return f.parse(o1.getDob()).compareTo(f.parse(o2.getDob()));
                } catch (ParseException ex) {
                    throw new IllegalArgumentException(ex);
                }
            }
        });
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            System.out.println("--------------------------------------------------Doctor--------------------------------------------------");
            System.out.printf("%s%8s%24s%9s%17s%18s%14s\n", "ID", "Name", "Dob", "Spec", "state", "email", "phone");
            for (Doctor d : list) {
                System.out.println(d);
            }
        }

    }

    public ArrayList<Doctor> getList() {
        return list;
    }

    public void setList(ArrayList<Doctor> list) {
        this.list = list;
    }

}
