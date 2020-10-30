/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Management m = new Management();
        Input v = new Input();
        String[] task = {"Add doctor","Edit doctor information","Delete a doctor",
            "Search by id","Search by name","Sort by dob","Show doctor","Exit"};       
        do{
            System.out.println("========= Doctor Management =========");
            for(int i=0; i<task.length; i++){
                System.out.println((i+1)+". "+ task[i]);
            }
            int choice = v.getChoice("Enter your choice: ");
            switch (choice) {
                case 1:
                    System.out.println("------------Add Doctor------------");
                    m.addDoctor();
                    break;
                case 2:
                    System.out.println("---------Edit Doctor--------");
                    System.out.println(m.editInfo(v.getID()));
                    break;
                case 3:
                    System.out.println("---------Delete Doctor--------");
                    System.out.println(m.deleteDoctor(v.getID()));
                    break;
                case 4:
                    System.out.println("---------Search Doctor--------");
                    System.out.println(m.searchID(v.getID()));
                    break;
                case 5:
                    System.out.println("---------Search Doctor--------");
                    System.out.println(m.searchName(v.getName("Enter name:")));
                    break;
                case 6:
                    System.out.println("---------Sort Doctor--------");
                    m.sortByDob();
                    break;
                case 7:
                    System.out.println("---------Show Doctor--------");
                    m.display();
                    break;
                case 8:
                    System.exit(0);
            }
        } while (true);
    }
}
