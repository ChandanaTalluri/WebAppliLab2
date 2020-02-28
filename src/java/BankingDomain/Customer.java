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
    
    private String userID = null;
    private  String strFirstName = null;
    private  String strLastName = null;
    private String strPhoneNumber = null;
    private String emialID = null;
    private String strPassword = null;
    private int custID;
    private boolean blUserIDExits;//boolean used to avoid registration with same user id

    public boolean isBlUserIDExits() {
        return blUserIDExits;
    }

    public void setBlUserIDExits(boolean blUserIDExits) {
        this.blUserIDExits = blUserIDExits;
    }
    
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

   

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
    public Customer(String userID,String strFirstName,String strLastName,String emialID,String strPhoneNumber,String strPassword ){
        this.userID = userID;
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
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
        strCustomizeToString = "User ID: "+ userID + "\n"+
                                "Customer ID: "+ custID +"\n"+
                                "Customer First Name: "+ strFirstName +"\n"+
                                "Customer Last Name: "+ strLastName +"\n"+
                                "Customer Contact: "+ strPhoneNumber + "\n";
        
        return strCustomizeToString;
    }
     public static ArrayList<Customer> getCustomers(){
        
        return CustomerDBA.getCustomers();
        
    }
    
     public static Customer loginCustomer(String custID,String strPassword) throws LoginException{
        //this method is used to check login
         Customer objCust = CustomerDBA.checklogin(custID, strPassword);
         System.out.println(objCust);
         return objCust;
     }
     public  Customer insertCustomer() throws LoginException{
         //this method is used to insert a new user
         Customer objnewCustomer = new Customer(userID, strFirstName, strLastName, emialID, strPhoneNumber, strPassword);
         
         ArrayList<Customer> arrObjCust = CustomerDBA.getCustomers();
         Customer objCustomerExists = CustomerDBA.checkUserID(userID, arrObjCust);
         if(objCustomerExists.isBlUserIDExits()){
             return objCustomerExists;
         }else{
             CustomerDBA.add(objnewCustomer);
             Customer objCustomer = CustomerDBA.findCustomerByID(userID, arrObjCust);
         return objCustomer;
         }
     }
     
}
