/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingDomain;

import DataAccessLayer.AssetAccountDBA;
import DataAccessLayer.LiabilityAccountDBA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chandana
 */
public class LiabilityAccount {
    private String strAccountNumber;
    private int custID;
    private String strAccountName;
    private Date dateOpened;

    public String getStrAccountNumber() {
        return strAccountNumber;
    }

    public void setStrAccountNumber(String strAccountNumber) {
        this.strAccountNumber = strAccountNumber;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getStrAccountName() {
        return strAccountName;
    }

    public void setStrAccountName(String strAccountName) {
        this.strAccountName = strAccountName;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }
    
     public static void init(){
        LiabilityAccountDBA.init();
    }

    @Override
    public String toString() {
        String strCustomizeToString = null;
        strCustomizeToString = "Customer account name: "+ strAccountName+"\n"+
                                "   Customer ID: "+ custID + "\n"+
                                "   Account Number: "+ strAccountNumber + "\n" +
                                "   Account Opening date: " +dateOpened;
        return strCustomizeToString;
    }
     public static ArrayList<LiabilityAccount> getLiabilityAccount(){
        
        return LiabilityAccountDBA.getLiabilityAccount();
        
    }

}
