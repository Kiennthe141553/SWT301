
import Validation.Validation;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Input {
    public static String getName(String mess) {
        String name = "";
        Scanner sc = new Scanner(System.in);
        do {        
            System.out.println(mess);
            try {              
                name = sc.nextLine();
                String namecheck = Validation.getName(name);
                if(name.equals(namecheck)){
                    return namecheck;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);
    }
    
    
    
    public static String getDob(String mess) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        String text = "";
        do {
            System.out.print(mess);
            try {              
                text = sc.nextLine();
                String dobcheck = Validation.getDob(text);
                return dobcheck;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } 
        }while(true);
        
    }
    
    public static String getSpec(String mess) {
        String spec = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(mess);
            try{
            spec = sc.nextLine();
            String speccheck = Validation.getSpec(spec);
            if(spec.equals(speccheck)){
                return speccheck;
            }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    public static int getState(String mess) throws Exception {
        Scanner in = new Scanner(System.in);
        String state = "";
        do {
            System.out.print(mess);
            try {               
                state = in.nextLine();
                int statecheck = Validation.getState(state);
                return statecheck;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    public static String getEmail(String mess){
        String email = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(mess);
            try{
            email = sc.nextLine();
            String emailcheck = Validation.getEmail(email);
            if(email.equals(emailcheck)){
                return emailcheck;
            }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    public static String getPhone(String mess){
        String phone = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(mess);
            try{
            phone = sc.nextLine();
            String phonecheck = Validation.getPhone(phone);
            if(phone.equals(phonecheck)){
                return phonecheck;
            }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    public static int getID() {
        Scanner sc = new Scanner(System.in);
        String id = "";
        do {
            System.out.println("Enter id: ");
            try {              
                id = sc.nextLine();
                int idcheck = Validation.getID(id);
                return idcheck;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (true);
    }
    
    public static int getChoice(String mess) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.print(mess);
                choice = Integer.parseInt(sc.nextLine());
                if (choice > 8 || choice < 1) {
                    System.out.println("Please choose from 1 to 8!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice!");
                continue;
            }
            break;
        } while (true);
        return choice;
    }
}
