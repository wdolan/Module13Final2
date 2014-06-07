/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Bella Belova
 */
public class Address {
    
    private int     AddressID;
    private int     CustomerID;
    private String  AddressType;
    private String  Address1;
    private String  Address2;
    private String  City;
    private String  State;
    private int     Zip;
    
    //Constructor
    
    public Address (int AddrID, int CustID, String AddrType, String Addr1, String Addr2, 
                        String AddrCity, String AddrState, int AddrZip ){
    
    AddressID = AddrID;
    CustomerID = CustID;
    AddressType = AddrType;
    Address1 = Addr1;
    Address2 = Addr2;
    City = AddrCity;
    State = AddrState;
    Zip = AddrZip;
    
    
    
    }
}