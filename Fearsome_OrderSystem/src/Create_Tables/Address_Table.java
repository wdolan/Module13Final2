/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

import Connect.*;



/**
 *
 * @author Gregory
 */
public class Address_Table {
    
    public static final String ADDRESS_TABLE_NAME = "FEFO_ADDRESS";  
    public static java.sql.Connection sqlConn;
    SQL sql_access;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Address_Table()
    {
        sql_access = new SQL();
        sqlConn = Connect.SQL.getSQLConn();
    }
    
    // Drop Table
    
    public void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + ADDRESS_TABLE_NAME + ";";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + ADDRESS_TABLE_NAME + " " + 
            "(AddressID integer identity (1,1) NOT NULL, " +
            "CustomerID integer NOT NULL, " +
            "AddressType varchar(10) NOT NULL, " +
            "Address1 varchar(50) NOT NULL, " +
            "Address2 varchar(50) NULL, " +
            "City varchar(50) NOT NULL, " + 
            "State varchar(50) NOT NULL, " + 
            "Zip integer NOT NULL, " +
            "PRIMARY KEY (AddressID), " + 
            "FOREIGN KEY (CustomerID) REFERENCES FEFO_CUSTOMERS (CustomerID)) ";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ADDRESS_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

        //Insert Address_Table data
    public void createAddress(int Addr_ID, int Cust_ID, String Addr_Type,
                                        String Addr1, String Addr2, String Addr_City, String Addr_State, int Addr_Zip) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "SET IDENTITY_INSERT " + ADDRESS_TABLE_NAME + " on insert into " + ADDRESS_TABLE_NAME + 
                  " (AddressID, CustomerID, AddressType, Address1, Address2, "
                  + "City, State, Zip) VALUES(" + Addr_ID + ", " + 
                    Cust_ID + ", '" + Addr_Type + "', '" + Addr1 + "', '" + Addr2 + "', '" + 
                    Addr_City + "', '" + Addr_State + "', " + Addr_Zip + ");" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Address in the Database." + "\nDetaill: " + e);
        }
    }
    
    public static java.util.ArrayList getAllAddresses()
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + ADDRESS_TABLE_NAME + ";" ;
          stmt = sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Address (rs.getInt("AddressID"), rs.getInt("CustomerID"), 
                        rs.getString("AddressType"), rs.getString("Address1"), rs.getString("Address2"), 
                        rs.getString("City"), rs.getString("State"), rs.getInt("Zip")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Address Table." + "\nDetaill: " + e);
        }
        return results;
    }

}
