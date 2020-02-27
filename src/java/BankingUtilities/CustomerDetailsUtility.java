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
import DataAccessLayer.AccountTransactionDBA;
import DataAccessLayer.AssetAccountDBA;
import DataAccessLayer.CustomerDBA;
import DataAccessLayer.LiabilityAccountDBA;
import java.util.ArrayList;

/**
 *
 * @author Chandana
 */
public class CustomerDetailsUtility {
    
    public static void findAndShowAllCustomers(ArrayList<Customer> arrListCustomer, ArrayList<AssetAccount> arrListAssetAccount, ArrayList<LiabilityAccount> arrListLiabilityAccount, ArrayList<Transaction> arrListTranscation) {
        try{
            System.out.println("List of Customers with account details");
            for(int i=0;i< arrListCustomer.size();i++ ){
            System.out.println("********************************************************");
            String custID = arrListCustomer.get(i).getUserID();
            Customer objCustomer  = CustomerDBA.findCustomerByID(custID, arrListCustomer);
            System.out.println(objCustomer);
            if(null!=custID){
                ArrayList<AssetAccount> arrLstAAResult = AssetAccountDBA.findAccountDetails(custID,arrListAssetAccount);
                if(null!= arrLstAAResult && arrLstAAResult.size()>0){
                    int iSize = arrLstAAResult.size();
                     System.out.println(objCustomer.getStrFirstName()+" has "+ iSize + " AssetAccount ");
                    for(int iCount = 0; iCount < iSize; iCount++){
                        System.out.println(arrLstAAResult.get(iCount));
                        ArrayList<Transaction> arrObjTransactions = AccountTransactionDBA.findTransactionDetails(arrLstAAResult.get(iCount).getStrAccountNumber(),arrListTranscation );
                        if(null != arrObjTransactions && arrObjTransactions.size()>0 ){
                            int iTSize = arrObjTransactions.size();
                            System.out.println(objCustomer.getStrFirstName()+" did "+ iTSize + " Transactions ");
                            for(int jCount =0 ;jCount<iTSize ; jCount++){
                                Transaction objTransactions = new Transaction();
                                System.out.println(arrObjTransactions.get(jCount));
                            }
                                    
                        }
                    }
                }
                ArrayList<LiabilityAccount> arrLstLAResult = LiabilityAccountDBA.findAccountDetails(custID,arrListLiabilityAccount);
                if(null!= arrLstLAResult && arrLstLAResult.size()>0){
                    int iLSize = arrLstLAResult.size();
                     System.out.println(objCustomer.getStrFirstName()+" has "+ iLSize + " Liability Account ");
                    for(int kCount = 0; kCount < iLSize; kCount++){
                        System.out.println(arrLstLAResult.get(kCount));
                        ArrayList<Transaction> arrObjTransactions = AccountTransactionDBA.findTransactionDetails(arrLstLAResult.get(kCount).getStrAccountNumber(),arrListTranscation );
                        if(null != arrObjTransactions && arrObjTransactions.size()>0 ){
                            int iLTSize = arrObjTransactions.size();
                            System.out.println(objCustomer.getStrFirstName()+" did "+ iLTSize + " Transactions ");
                            for(int j =0 ;j<iLTSize ; j++){
                                System.out.println(arrObjTransactions.get(j));
                            }
                            System.out.println("");
                        }
                    }
                }
            }
        }
        }catch(Exception e ){
            System.out.println("BankingUtilities.CustomerDetailsUtility.findAndShowAllCustomers()");
            System.out.println(e.getMessage());
        }
    }
}
