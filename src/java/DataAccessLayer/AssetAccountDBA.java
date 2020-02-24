/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import BankingDomain.AssetAccount;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chandana
 */
public class AssetAccountDBA {
    private static ArrayList<AssetAccount> objArrListAssetAccount = new ArrayList<AssetAccount>();
    public static void init(){
        //Addeing strMethodName to trace error in future.
        String strMethodName =" Entereed method AssetAccountDBA.init()";
        
        try{
            AssetAccount objAssetAccount = new AssetAccount();
            objAssetAccount.setCustID(101);
            objAssetAccount.setStrAccountName("Customer ONE");
            //for furthur usage giving Account number that starts with LA 
            //AA will indicate it is Asset account
            objAssetAccount.setStrAccountNumber("AA111922236561");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString = "31-07-2019 10:20:56";
            Date mydate = sdf.parse(dateInString);
            objAssetAccount.setDateOpened(mydate);
            add(objAssetAccount);
            AssetAccount objAssetAccount1 = new AssetAccount();
            objAssetAccount1.setCustID(102);
            objAssetAccount1.setStrAccountName("Customer TWO");
            objAssetAccount1.setStrAccountNumber("AA222922236561");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString1 = "28-04-2019 11:20:56";
            Date mydate1 = sdf1.parse(dateInString1);
            objAssetAccount1.setDateOpened(mydate1);
            add(objAssetAccount1);
        }catch(Exception e){
            System.out.println(strMethodName);
            System.out.println(e.getMessage());
        }
        
        
        
    }
    public static ArrayList<AssetAccount> getAssetAccount(){
        
        return objArrListAssetAccount;
        
    }
    public static void add(AssetAccount objAssetAccount){
        objArrListAssetAccount.add(objAssetAccount);
    }

    public static ArrayList<AssetAccount> findAccountDetails(String custID, ArrayList<AssetAccount> arrListAssetAccount) {
       ArrayList<AssetAccount> objAA = new ArrayList<AssetAccount>();
        if(null != arrListAssetAccount && arrListAssetAccount.size()>0){
            int iSize = arrListAssetAccount.size();
            for(int iCount = 0 ; iCount<iSize ; iCount++){
                if(custID.equals(arrListAssetAccount.get(iCount).getCustID())){
                    objAA.add(arrListAssetAccount.get(iCount));
                }
            }
        }
        return objAA;
    }
}
