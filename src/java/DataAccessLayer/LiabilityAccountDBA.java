/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;


import BankingDomain.LiabilityAccount;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chandana
 */
public class LiabilityAccountDBA {
    private static ArrayList<LiabilityAccount> objArrListLiabilityAccount = new ArrayList<LiabilityAccount>();
    public static void init(){
            //Addeing strMethodName to trace error in future.
        String strMethodName =" Entereed method LiabilityAccountDBA.init()";
        try{
            LiabilityAccount objLiabilityAccount = new LiabilityAccount();
            objLiabilityAccount.setCustID(103);
            objLiabilityAccount.setStrAccountName("Customer THREE");
            //for furthur usage giving Account number that starts with LA 
            //LA will indicate it is Liability account
            objLiabilityAccount.setStrAccountNumber("LA333922236561");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString = "13-01-2020 10:20:56";
            Date mydate = sdf.parse(dateInString);
            objLiabilityAccount.setDateOpened(mydate);
            add(objLiabilityAccount);
            //2
            LiabilityAccount objLiabilityAccount2 = new LiabilityAccount();
            objLiabilityAccount2.setCustID(101);
            objLiabilityAccount2.setStrAccountName("Customer ONE");
            //for furthur usage giving Account number that starts with LA 
            //LA will indicate it is Liability account
            objLiabilityAccount2.setStrAccountNumber("LA111922236561");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString2 = "01-02-2020 11:20:56";
            Date mydate2 = sdf2.parse(dateInString2);
            objLiabilityAccount2.setDateOpened(mydate2);
            add(objLiabilityAccount2);
        }catch(Exception e){
            System.out.println(strMethodName);
            System.out.println(e.getMessage());
        }

        
    }
    public static ArrayList<LiabilityAccount> getLiabilityAccount(){
        
        return objArrListLiabilityAccount;
        
    }
    public static void add(LiabilityAccount objLiabilityAccount){
        objArrListLiabilityAccount.add(objLiabilityAccount);
    }

    public static ArrayList<LiabilityAccount> findAccountDetails(String custID, ArrayList<LiabilityAccount> arrListLiabilityAccount) {
       ArrayList<LiabilityAccount> objLA = new ArrayList<LiabilityAccount>();
        if(null != arrListLiabilityAccount && arrListLiabilityAccount.size()>0){
            int iSize = arrListLiabilityAccount.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(custID.equals(arrListLiabilityAccount.get(iCount).getCustID())){
                    objLA.add(arrListLiabilityAccount.get(iCount));
                }
            }
        }
        return objLA;
    }
}
