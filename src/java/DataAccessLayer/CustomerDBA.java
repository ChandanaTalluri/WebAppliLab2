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
        objCustomer.setCustID("101");
        objCustomer.setStrFirstName("Customer");
        objCustomer.setStrLastName("ONE");
        objCustomer.setEmialID("one@cust");
        objCustomer.setStrPhoneNumber("1116358945");
        objCustomer.setStrPassword("qwerty");
        add(objCustomer);
        Customer objCustomer1 = new Customer();
        objCustomer1.setCustID("102");
        objCustomer1.setStrFirstName("Customer");
        objCustomer1.setStrLastName("TWO");
        objCustomer1.setEmialID("two@cust");
        objCustomer1.setStrPhoneNumber("2226358945");
        objCustomer1.setStrPassword("102");
        add(objCustomer1);
        Customer objCustomer2 = new Customer();
        objCustomer2.setCustID("103");
        objCustomer2.setStrFirstName("Customer");
        objCustomer2.setStrLastName("Three");
        objCustomer2.setEmialID("three@cust");
        objCustomer2.setStrPhoneNumber("3336358945");
        objCustomer2.setStrPassword("qwerty");
        add(objCustomer2);
        
    }
    public static ArrayList<Customer> getCustomers(){
        
        return objArrListCustomer;
        
    }
    public static void add(Customer c){
        objArrListCustomer.add(c);
    }
    public static Customer findCustomerByID(String custID, ArrayList<Customer> arrObjCustomer){
        Customer objCustomer = new Customer();
        if(null != arrObjCustomer && arrObjCustomer.size()>0){
            int iSize = arrObjCustomer.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(custID.equals(arrObjCustomer.get(iCount).getCustID())){
                    objCustomer.setCustID(arrObjCustomer.get(iCount).getCustID());
                    objCustomer.setStrFirstName(arrObjCustomer.get(iCount).getStrFirstName());
                    objCustomer.setStrPhoneNumber(arrObjCustomer.get(iCount).getStrPhoneNumber());
                    objCustomer.setStrLastName(arrObjCustomer.get(iCount).getStrLastName());
                    objCustomer.setEmialID(arrObjCustomer.get(iCount).getEmialID());
                    }
                break;
            }
        }
        return objCustomer;
    }

    public static Customer checklogin(String custID, String strPassword) {
        Customer objCustomer = new Customer();
        ArrayList<Customer> arrObjCustomer = Customer.getCustomers();
        if(null != arrObjCustomer && arrObjCustomer.size()>0){
            int iSize = arrObjCustomer.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(custID.equals(arrObjCustomer.get(iCount).getCustID())
                        && strPassword.equals(arrObjCustomer.get(iCount).getStrPassword())
                        ){
                    objCustomer.setCustID(arrObjCustomer.get(iCount).getCustID());
                    objCustomer.setStrFirstName(arrObjCustomer.get(iCount).getStrFirstName());
                    objCustomer.setStrPhoneNumber(arrObjCustomer.get(iCount).getStrPhoneNumber());
                    objCustomer.setStrLastName(arrObjCustomer.get(iCount).getStrLastName());
                      break;
                    }   
            }
        }
        return objCustomer;
    }
    
}

    

