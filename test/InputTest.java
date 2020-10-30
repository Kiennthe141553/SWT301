
import Validation.Validation;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class InputTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    
    //Test add doctor, input normal name
    @Test
    public void testAddDoctor_inputName_normal() throws Exception {
        String name = "le trung kien";
        String expected = "le trung kien";
        Assert.assertEquals(expected, Validation.getName(name));
    }
    
    //Test add doctor, input name exactly boundary
    @Test
    public void testAddDoctor_inputName_boundary() throws Exception {
        String name = "aamcnelfitoakzcnejtdkqopdlwkcmwasjekfwofiejrkgmeks";
        String expected = "aamcnelfitoakzcnejtdkqopdlwkcmwasjekfwofiejrkgmeks";
        Assert.assertEquals(expected, Validation.getName(name));
    }
    
    //Test add doctor, input name more than 50 characters
    @Test
    public void testAddDoctor_inputName_abnormal() throws Exception {
        String expected = "Name can not greater than 50 character!";
        thrown.expectMessage(expected);
        String name = "ten cua toi la le trung kien, lop se 1411, toi dang hoc ky 5, swt301 thay pham ngoc ha";
        String check = Validation.getName(name);
    }
    
    //Test add doctor, input date of birth in format dd/MM/yyyy
    @Test
    public void testAddDoctor_inputDOB_normal() throws Exception {
        String dob = "12/05/2002";
        String expected = "12/05/2002";
        Assert.assertEquals(expected, Validation.getDob(dob));
    }
    
    //Test add doctor, input normal state
    @Test
    public void testAddDoctor_inputState_normal() throws Exception {
        String state = "0";
        int expected = 0;
        Assert.assertEquals(expected, Validation.getState(state));
    }
    
    //Test add doctor, input state that is a string not integer
    @Test
    public void testAddDoctor_inputState_abnormal() throws Exception {        
        String expected = "Invalid state!";
        thrown.expectMessage(expected);
        String state = "abcjowewle";
        int check = Validation.getState(state);
    }
    
    //Test add doctor, input specialization extractly boundary
    @Test
    public void testAddDoctor_inputSpecial_boundary() throws Exception {
        String spec = "asdwrkwekrkwekrkdfkkwekkwrjwejoldlasdqwjeqwjrwqlrwkrqjewrkkdnnwerkwekrlwjjrwjeejeee"
                + "eeeeeedddddddddddddddddddddwwwwwwwwwwwwwqqqqqqqqqqqqqqqqqqqqqqfffffffffffffeeeeeeeee"
                + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeerrrrrrrrrrrrrrrrrrrwwwwwwcccccccsabcde";
        String expected = "asdwrkwekrkwekrkdfkkwekkwrjwejoldlasdqwjeqwjrwqlrwkrqjewrkkdnnwerkwekrlwjjrwjeejeeeeeeeeed"
                + "ddddddddddddddddddddwwwwwwwwwwwwwqqqqqqqqqqqqqqqqqqqqqqfffffffffffffeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
                + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeerrrrrrrrrrrrrrrrrrrwwwwwwcccccccsabcde";
        Assert.assertEquals(expected, Validation.getSpec(spec));
    }
    
    //Test edit doctor, input normal id
    @Test
    public void testEditDoctor_inputID_normal() throws Exception {
        int id = 1;
        int expected = 1;
        Assert.assertEquals(expected, Validation.getID(String.valueOf(id)));
    }
    
    //Test edit doctor, input id that is a string
    @Test
    public void testEditDoctor_inputID_abnormal() throws Exception {
        String expected = "Id must be an integer!";
        thrown.expectMessage(expected);
        String id = "abcdef";
        Validation.getID(id);
    }
    
    //Test edit doctor, input id is integer but not exist in the list
    @Test
    public void testEditDoctor_inputID_abnormal_notexist() throws Exception {
        Input v = new Input();
        int id = 25;
        String expected = "ID not found!";      
        Management m = new Management();
        Assert.assertEquals(expected, m.editInfo(id));
    }
    
    //Test search doctor, input id exist in the list
    @Test
    public void testSearchDoctor_inputID_normal() {
        Input v = new Input();
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor(1,"kien","12/02/2000","kaka",1,"kien@gmail.com","012-345-6789"));
        int id = 1;
        String expected = "1,kien,12/02/2000,kaka,Available,kien@gmail.com,012-345-6789".trim();      
        Management m = new Management();
        m.setList(list);
        m.searchID(id);
        Assert.assertEquals(expected, m.searchID(id));
    }
    
    //Test search doctor, input id is integer but not exist in the list
    @Test
    public void testSearchDoctor_inputID_abnormal() {
        Input v = new Input();
        int id = 1;
        String expected = "Not Found!";      
        Management m = new Management();
        m.searchID(id);
        Assert.assertEquals(expected, m.searchID(id));
    }
    
    //Test search doctor, input normal name and exist in the list
    @Test
    public void testSearchDoctor_inputName_normal() {
        Input v = new Input();
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor(1,"kien","12/02/2000","kaka",1,"kien@gmail.com","012-345-6789"));
        String name = "kien";
        String expected = "1,kien,12/02/2000,kaka,Available,kien@gmail.com,012-345-6789".trim();      
        Management m = new Management();
        m.setList(list);
        m.searchName(name);
        Assert.assertEquals(expected, m.searchName(name));
    }
    
    //Test search doctor, input normal name but not exist in the list
    @Test
    public void testSearchDoctor_inputName_abnormal_notexist() {
        Input v = new Input();
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor(1,"kien","12/02/2000","kaka",1,"kien@gmail.com","012-345-6789"));
        list.add(new Doctor(2,"thanh","12/04/2002","kafefotai",3,"thanhthanh@gmail.com","192-354-1284"));
        String name = "quang";
        String expected = "Not Found!";      
        Management m = new Management();
        m.setList(list);
        m.searchName(name);
        Assert.assertEquals(expected, m.searchName(name));
    }
    
    //Test add doctor, email not follow formar xxx@xxx.com 
    @Test
    public void testAddDoctor_inputEmail_abnormal() throws Exception {
        String expected = "Enter email again!";
        thrown.expectMessage(expected);
        String email = "kienkk.com";
        String check = Validation.getEmail(email);
    }
    
    //Test add doctor, input phone not follow format xxx-xxx-xxxx
    @Test
    public void testAddDoctor_inputPhone_abnormal() throws Exception {
        String expected = "Phone must in format 000-000-0000!";
        thrown.expectMessage(expected);
        String phone = "1923526849";
        String check = Validation.getPhone(phone);
    }
    
    //Test add doctor, input phone normal
    @Test
    public void testAddDoctor_inputPhone_normal() throws Exception {
        String expected = "123-456-7890";
        String phone = "123-456-7890";
        Assert.assertEquals(expected, Validation.getPhone(phone));
    }
    
    //Test delete doctor, id is a string abnormal
    @Test
    public void testDeleteDoctor_inputID_abnormal() throws Exception {
        String expected = "Id must be an integer!";
        thrown.expectMessage(expected);
        String id = "abc";
        Validation.getID(id);
    }
    
    //Test delete doctor, successfully delete
    @Test
    public void testDeleteDoctor_inputID_normal() throws Exception {
        Management m = new Management();
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor(1,"kien","12/02/2000","kaka",1,"kien@gmail.com","012-345-6789"));
        list.add(new Doctor(2,"thanh","12/04/2002","kafefotai",3,"thanhthanh@gmail.com","192-354-1284"));
        m.setList(list);
        String expected = "Delete successfully!";
        int id = 1;
        Assert.assertEquals(expected, m.deleteDoctor(id));
    }
    
    //Test delete doctor, doctor not exist in list
    @Test
    public void testDeleteDoctor_inputID_abnormal_notexist() {
        Management m = new Management();
        ArrayList<Doctor> list = new ArrayList<>();
        list.add(new Doctor(1,"kien","12/02/2000","kaka",1,"kien@gmail.com","012-345-6789"));
        list.add(new Doctor(2,"thanh","12/04/2002","kafefotai",3,"thanhthanh@gmail.com","192-354-1284"));
        m.setList(list);
        Input v = new Input();
        int id = 46;
        String expected = "ID not found!";             
        Assert.assertEquals(expected, m.deleteDoctor(id));
    }
    
    
}
