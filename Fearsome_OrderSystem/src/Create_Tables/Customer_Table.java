/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

import static Create_Tables.Address_Table.ADDRESS_TABLE_NAME;
import static Create_Tables.Address_Table.sqlConn;
import  Connect.*;


/**
 *
 * @author Gregory
 */
public class Customer_Table {
    
    public static final String CUSTOMER_TABLE_NAME = "FEFO_CUSTOMERS";
    public static java.sql.Connection sqlConn;
    SQL sql_access;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Customer_Table()
    {
        sql_access = new SQL();
        sqlConn = Connect.SQL.getSQLConn();
    }
    // Drop Table
    
    public void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + CUSTOMER_TABLE_NAME + ";";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
       
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + CUSTOMER_TABLE_NAME + " " + 
            "(CustomerID integer identity (1,1) NOT NULL, " +
            "FirstName varchar(50) NOT NULL, " +
            "LastName varchar(50) NOT NULL, " +
            "BillAddress integer NOT NULL, " + 
            "ShipAddress integer NOT NULL, " + 
            "EmailAddress varchar(50) NOT NULL, " + 
            "PhoneNumber varchar(13) NULL, " + 
            "OrderIDs integer NULL, " +
            "PRIMARY KEY (CustomerID))";
/*                    
            "FOREIGN KEY (BillAddress) REFERENCES FEARSOME_ADDRESS (AddressID), " + 
            "FOREIGN KEY (ShipAddress) REFERENCES FEARSOME_ADDRESS (AddressID), " + 
            "FOREIGN KEY (OrderIDs) REFERENCES FEARSOME_ORDERS (OrderID)) ";
            * 
            */ 
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + CUSTOMER_TABLE_NAME + "\nDetaill: " + e);
        }        
    }
    
/**
 * @author Bella Belova
 * @param CustomerID A unique Customer_Table ID
 * @param FirstName Customer_Table First Name
 * @param LastName Customer_Table Last Name
 * @param BillAddress An integer that except "0" or "1" for checked or unchecked Billing Address
 * @param ShipAddress An integer that except "0" or "1" for checked or unchecked Shipping Address
 * @param EmailAddress Customer_Table EMail Address
 * @param PhoneNumber String field that will except parenthesis and numbers
 * @param OrderIDs Order Number
 * @throws TableException This exception represents a problem with the access and updating of the DB table.
 */
    
    //Insert Customer_Table data
    public void createCustomer(int Cust_ID, String FName, String LName, int BillAddr, 
                                        int ShipAddr, String EMail, String PhNbr, int OrderNbr) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "SET IDENTITY_INSERT " + CUSTOMER_TABLE_NAME + " on insert into " + CUSTOMER_TABLE_NAME + 
                  " (CustomerID, FirstName, LastName, BillAddress, ShipAddress, "
                  + "EmailAddress, PhoneNumber, OrderIDs) VALUES(" +
                    Cust_ID + ", '" + FName + "', '" + LName + "', " + BillAddr + ", " + 
                    ShipAddr + ", '" + EMail + "', '" + PhNbr + "', " + OrderNbr + ");" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Customer in the Database." + "\nDetaill: " + e);
        }
    }
    
    public static java.util.ArrayList getAllCustomers()
            throws Address_Table.TableException, TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + CUSTOMER_TABLE_NAME + ";" ;
          stmt = sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Customer (rs.getInt("CustomerID"), rs.getString("FirstName"), 
                        rs.getString("LastName"), rs.getInt("BillAddress"), rs.getInt("ShipAddress"), 
                        rs.getString("EmailAddress"), rs.getString("PhoneNumber"), rs.getInt("OrderIDs")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Customer Table." + "\nDetaill: " + e);
        }
        return results;
    }
}
