/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingUtilities;

import BankingDomain.AssetAccount;
import BankingDomain.Customer;
import BankingDomain.LiabilityAccount;
import BankingDomain.Transaction;
import java.util.ArrayList;

/**
 *
 * @author Chandana
 */
public class BankingSystem {
    public static void main(String[] args){
        
        Customer.init();
        ArrayList<Customer> arrListCustomer = Customer.getCustomers();
        AssetAccount.init();
        ArrayList<AssetAccount> arrListAssetAccount = AssetAccount.getAssetAccount();
        LiabilityAccount.init();
        ArrayList<LiabilityAccount> arrListLiabilityAccount = LiabilityAccount.getLiabilityAccount();
        Transaction.init();
        ArrayList<Transaction> arrListTranscation = Transaction.getTransaction();
        
        CustomerDetailsUtility.findAndShowAllCustomers(arrListCustomer,arrListAssetAccount,arrListLiabilityAccount,arrListTranscation);
    }
    
}
