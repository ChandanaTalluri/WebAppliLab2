/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingDomain;

import BankingExceptions.LoginException;
import DataAccessLayer.CustomerDBA;
import java.util.ArrayList;

/**
 *
 * @author Chandana
 */
public class Customer {
    
    private int custID;
    private  String strCustomerName;
    private String strPhoneNumber;
    private String strPassword;

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }
    
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getStrCustomerName() {
        return strCustomerName;
    }

    public void setStrCustomerName(String strCustomerName) {
        this.strCustomerName = strCustomerName;
    }

    public String getStrPhoneNumber() {
        return strPhoneNumber;
    }

    public void setStrPhoneNumber(String strPhoneNumber) {
        this.strPhoneNumber = strPhoneNumber;
    }
   
    
    public static void init(){
        CustomerDBA.init();
    }

    @Override
    public String toString() {
        String strCustomizeToString = null;
        strCustomizeToString = "Customer ID: "+ custID + "\n"+
                                "Customer Name: "+ strCustomerName +"\n"+
                                "Customer Contact: "+ strPhoneNumber + "\n";
        
        return strCustomizeToString;
    }
     public static ArrayList<Customer> getCustomers(){
        
        return CustomerDBA.getCustomers();
        
    }
    
     public static Customer loginCustomer(String custID,String pass) throws LoginException{
         
         return new Customer();
     }
}
