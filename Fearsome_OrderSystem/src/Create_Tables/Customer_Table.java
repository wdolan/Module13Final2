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
 * @author Bella Belova
 */
public class Customer_Table {
    
    public static final String CUSTOMER_TABLE_NAME = "3C_CUSTOMERS";
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
            "(CUSTOMER_ID integer identity (1,1) NOT NULL, " +
            "FIRST_NAME varchar(50) NOT NULL, " +
            "LAST_NAME varchar(50) NOT NULL, " +
            "BILL_ADDRESS integer NOT NULL, " + 
            "SHIP_ADDRESS integer NOT NULL, " + 
            "EMAIL varchar(50) NOT NULL, " + 
            "PHONE varchar(13) NULL, " + 
            "PRIMARY KEY (CUSTOMER_ID))";
/*                    
            "FOREIGN KEY (BILL_ADDRESS) REFERENCES 3C_ADDRESS (ADDRESS_ID), " + 
            "FOREIGN KEY (SHIP_ADDRESS) REFERENCES 3C_ADDRESS (ADDRESS_ID), " + 
            * 
            */ 
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + CUSTOMER_TABLE_NAME + "\nDetail: " + e);
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
 * @throws TableException This exception represents a problem with the access and updating of the DB table.
 */
    
    //Insert Customer_Table data
    public void createCustomer(int Cust_ID, String FName, String LName, int BillAddr, 
                                        int ShipAddr, String EMail, String PhNbr) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "SET IDENTITY_INSERT " + CUSTOMER_TABLE_NAME + " on insert into " + CUSTOMER_TABLE_NAME + 
                  " (CUSTOMER_ID, FIRST_NAME, LAST_NAME, BILL_ADDRESS, SHIP_ADDRESS, "
                  + "EMAIL, PHONE) VALUES(" +
                    Cust_ID + ", '" + FName + "', '" + LName + "', " + BillAddr + ", " + 
                    ShipAddr + ", '" + EMail + "', '" + PhNbr + "');" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Customer in the Database." + "\nDetail: " + e);
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
                results.add(new OrderSystem_Classes.Customer (rs.getInt("CUSTOMER_ID"), rs.getString("FIRST_NAME"), 
                        rs.getString("LAST_NAME"), rs.getInt("BILL_ADDRESS"), rs.getInt("SHIP_ADDRESS"), 
                        rs.getString("EMAIL"), rs.getString("PHONE")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Customer Table." + "\nDetail: " + e);
        }
        return results;
    }
}
