/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Gregory
 */
public class Customer {
    
    private int     CustomerID;
    private String  FirstName;
    private String  LastName;
    private int     BillAddress;
    private int     ShipAdddress;
    private String  EmailAddress;
    private String  Customer_Phone;
    private int     OrderIDs;
    

    // Constructor 
    
    public Customer (int CustID, String FName, String LName, int BillAddr, int ShipAddr, 
                        String EMail, String PhNbr, int OrderID ){
    
    CustomerID      =  CustID; 
    FirstName       =  FName;
    LastName        =  LName;
    BillAddress     =  BillAddr;
    ShipAdddress    =  ShipAddr;
    EmailAddress    =  EMail;
    Customer_Phone  =  PhNbr;
    OrderIDs        =  OrderID;
    
    }
    
    // The output string to pull data from database
    public String toString(){
        return CustomerID + ":" + FirstName + " " + LastName;
    }


}

    

