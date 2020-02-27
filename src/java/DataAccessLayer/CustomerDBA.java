/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import BankingDomain.Customer;
import java.util.ArrayList;

/**
 *
 * @author Chandana
 */
public class CustomerDBA {
    private static ArrayList<Customer> objArrListCustomer = new ArrayList<Customer>();
    public static void init(){
        Customer objCustomer = new Customer();
        objCustomer.setUserID("Cust1");
        objCustomer.setStrFirstName("Customer");
        objCustomer.setStrLastName("ONE");
        objCustomer.setEmialID("one@cust");
        objCustomer.setStrPhoneNumber("1116358945");
        objCustomer.setStrPassword("cust1");
        objCustomer.setCustID(1);
        add(objCustomer);
        Customer objCustomer1 = new Customer();
        objCustomer1.setUserID("Cust2");
        objCustomer1.setStrFirstName("Customer");
        objCustomer1.setStrLastName("TWO");
        objCustomer1.setEmialID("two@cust");
        objCustomer1.setStrPhoneNumber("2226358945");
        objCustomer1.setStrPassword("cust2");
        objCustomer1.setCustID(2);
        add(objCustomer1);
        Customer objCustomer2 = new Customer();
        objCustomer2.setUserID("Cust3");
        objCustomer2.setStrFirstName("Customer");
        objCustomer2.setStrLastName("Three");
        objCustomer2.setEmialID("three@cust");
        objCustomer2.setStrPhoneNumber("3336358945");
        objCustomer2.setStrPassword("cust3");
        objCustomer2.setCustID(3);
        add(objCustomer2);
        
    }
    public static ArrayList<Customer> getCustomers(){
        
        return objArrListCustomer;
        
    }
    public static void add(Customer c){
        int custID = c.getCustID();
        if(custID==1){
            c.setCustID(1 +objArrListCustomer.size());
        }
        objArrListCustomer.add(c);
    }
    public static Customer findCustomerByID(String userID, ArrayList<Customer> arrObjCustomer){
        Customer objCustomer = new Customer();
        if(null != arrObjCustomer && arrObjCustomer.size()>0){
            int iSize = arrObjCustomer.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(userID.equals(arrObjCustomer.get(iCount).getUserID())){
                    objCustomer.setUserID(arrObjCustomer.get(iCount).getUserID());
                    objCustomer.setStrFirstName(arrObjCustomer.get(iCount).getStrFirstName());
                    objCustomer.setStrPhoneNumber(arrObjCustomer.get(iCount).getStrPhoneNumber());
                    objCustomer.setStrLastName(arrObjCustomer.get(iCount).getStrLastName());
                    objCustomer.setEmialID(arrObjCustomer.get(iCount).getEmialID());
                     break;
                    }
            }
        }
        return objCustomer;
    }
    public static Customer checkUserID(String userID, ArrayList<Customer> arrObjCustomer){
        Customer objCustomer = new Customer();
        if(null != arrObjCustomer && arrObjCustomer.size()>0){
            int iSize = arrObjCustomer.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(userID.equals(arrObjCustomer.get(iCount).getUserID())){
                    objCustomer.setStrLoginStatus("User ID already exists" +"\n"+" Please try with other User ID");
                    objCustomer.setBlUserIDExits(true);
                    break;
                    }
               
            }
        }
        return objCustomer;
    }
    public static Customer checklogin(String userID, String strPassword) {
        Customer objCustomer = new Customer();
        ArrayList<Customer> arrObjCustomer = Customer.getCustomers();
        if(null != arrObjCustomer && arrObjCustomer.size()>0){
            int iSize = arrObjCustomer.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(userID.equals(arrObjCustomer.get(iCount).getUserID())
                        && strPassword.equals(arrObjCustomer.get(iCount).getStrPassword())
                        ){
                    objCustomer.setUserID(arrObjCustomer.get(iCount).getUserID());
                    objCustomer.setStrFirstName(arrObjCustomer.get(iCount).getStrFirstName());
                    objCustomer.setStrPhoneNumber(arrObjCustomer.get(iCount).getStrPhoneNumber());
                    objCustomer.setStrLastName(arrObjCustomer.get(iCount).getStrLastName());
                    return objCustomer;
                    }
            }
            for(int jCount = 0 ; jCount<iSize ; jCount++){
                 if(userID.equals(arrObjCustomer.get(jCount).getUserID())
                        && !strPassword.equals(arrObjCustomer.get(jCount).getStrPassword())
                        ){
                    objCustomer.setStrLoginStatus("Password incorrect"+" \n"+" Please try again");
                    break;
                }
                else if(!userID.equals(arrObjCustomer.get(jCount).getUserID())
                        && !strPassword.equals(arrObjCustomer.get(jCount).getStrPassword())
                        ){
                    objCustomer.setStrLoginStatus("User ID and password is incorrect"+" \n"+" Please try again");
                    break;
                }
            }
        }
        return objCustomer;
    }
    
}

    

