/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingDomain;

import BankingExceptions.LoginException;
import DataAccessLayer.CustomerDBA;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Chandana
 */
public class Customer implements Serializable{
    
    private String custID;
    private  String strFirstName;
    private  String strLastName;
    private String strPhoneNumber;
    private String emialID;
    private String strPassword;

    public String getStrFirstName() {
        return strFirstName;
    }

    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    public String getStrLastName() {
        return strLastName;
    }

    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    public String getEmialID() {
        return emialID;
    }

    public void setEmialID(String emialID) {
        this.emialID = emialID;
    }
    
    public Customer(){
        
    }
    public Customer(String custID,String strFirstName,String strLastName,String emialID,String strPhoneNumber,String strPassword ){
        this.custID = custID;
        this.strFirstName = strFirstName;
        this.strLastName= strLastName;
        this.strPhoneNumber= strPhoneNumber;
        this.strPassword = strPassword;
        this.emialID = emialID;
    }
    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }
    
    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
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
                                "Customer First Name: "+ strFirstName +"\n"+
                                "Customer Last Name: "+ strLastName +"\n"+
                                "Customer Contact: "+ strPhoneNumber + "\n";
        
        return strCustomizeToString;
    }
     public static ArrayList<Customer> getCustomers(){
        
        return CustomerDBA.getCustomers();
        
    }
    
     public static Customer loginCustomer(String custID,String strPassword) throws LoginException{
         Customer.init();
         ArrayList<Customer> objArrayList = Customer.getCustomers();
         Customer objCust = CustomerDBA.checklogin(custID, strPassword,objArrayList);
         return objCust;
     }
     public  Customer insertCustomer(){
         CustomerDBA.add(new Customer(custID, strFirstName, strLastName, emialID, strPhoneNumber, strPassword));
         ArrayList<Customer> arrCustomer = new ArrayList<Customer>();
         arrCustomer = CustomerDBA.getCustomers();
         for(int i =0; i<arrCustomer.size();i++){
              System.out.println(arrCustomer.get(i));
         }
         return arrCustomer.get(0);
     }
}
