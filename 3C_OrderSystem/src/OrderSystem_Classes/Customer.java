/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Bella Belova
 */
public class Customer {
    
    private int     CustomerID;
    private String  FirstName;
    private String  LastName;
    private int     BillAddress;
    private int     ShipAdddress;
    private String  EmailAddress;
    private String  Customer_Phone;
    

    // Constructor 
    
    public Customer (int CustID, String FName, String LName, int BillAddr, int ShipAddr, 
                        String EMail, String PhNbr){
    
    CustomerID      =  CustID; 
    FirstName       =  FName;
    LastName        =  LName;
    BillAddress     =  BillAddr;
    ShipAdddress    =  ShipAddr;
    EmailAddress    =  EMail;
    Customer_Phone  =  PhNbr;  
    }
    
    // The output string to pull data from database
    public String toString(){
        return CustomerID + ":" + FirstName + " " + LastName;
    }


}

    

