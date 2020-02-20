/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingDomain;

import DataAccessLayer.AccountTransactionDBA;
import DataAccessLayer.LiabilityAccountDBA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chandana
 */
public class Transaction {
    
    private int transactionID;
    private Date dateOfTranscation;
    private String strAccountNumber;
    private double trasactionAmount;
    private String strDescription;

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Date getDateOfTranscation() {
        return dateOfTranscation;
    }

    public void setDateOfTranscation(Date dateOfTranscation) {
        this.dateOfTranscation = dateOfTranscation;
    }

    public String getStrAccountNumber() {
        return strAccountNumber;
    }

    public void setStrAccountNumber(String strAccountNumber) {
        this.strAccountNumber = strAccountNumber;
    }

    public double getTrasactionAmount() {
        return trasactionAmount;
    }

    public void setTrasactionAmount(double trasactionAmount) {
        this.trasactionAmount = trasactionAmount;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }
    
     public static void init(){
        AccountTransactionDBA.init();
    }

    @Override
    public String toString() {
        String strCustomizeToString = null;
        strCustomizeToString =  "Trasaction details for account Number: "+ strAccountNumber + "\n" +
                                "   Transaction ID: "+ transactionID + "\n" +
                                "   Transaction Date: "+ dateOfTranscation + "\n" +
                                "   Amount: $." +trasactionAmount +"\n "+
                                "  Message for Customer: " +strDescription;
        return strCustomizeToString;
    }
     public static ArrayList<Transaction> getTransaction(){
        
        return AccountTransactionDBA.getTransaction();
        
    }
}
