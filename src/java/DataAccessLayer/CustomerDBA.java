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
        objCustomer.setCustID(101);
        objCustomer.setStrCustomerName("Customer ONE");
        objCustomer.setStrPhoneNumber("1116358945");
        add(objCustomer);
        Customer objCustomer1 = new Customer();
        objCustomer1.setCustID(102);
        objCustomer1.setStrCustomerName("Customer TWO");
        objCustomer1.setStrPhoneNumber("2226358945");
        add(objCustomer1);
        Customer objCustomer2 = new Customer();
        objCustomer2.setCustID(103);
        objCustomer2.setStrCustomerName("Customer THREE");
        objCustomer2.setStrPhoneNumber("3336358945");
        add(objCustomer2);
        
    }
    public static ArrayList<Customer> getCustomers(){
        
        return objArrListCustomer;
        
    }
    public static void add(Customer c){
        objArrListCustomer.add(c);
    }
    public static Customer findCustomerByID(int custID, ArrayList<Customer> arrObjCustomer){
        Customer objCustomer = new Customer();
        if(null != arrObjCustomer && arrObjCustomer.size()>0){
            int iSize = arrObjCustomer.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(custID == arrObjCustomer.get(iCount).getCustID()){
                    objCustomer.setCustID(arrObjCustomer.get(iCount).getCustID());
                    objCustomer.setStrCustomerName(arrObjCustomer.get(iCount).getStrCustomerName());
                    objCustomer.setStrPhoneNumber(arrObjCustomer.get(iCount).getStrPhoneNumber());
                }
            }
        
        }
        return objCustomer;
    }
}
