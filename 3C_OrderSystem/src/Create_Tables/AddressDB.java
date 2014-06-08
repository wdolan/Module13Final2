/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

import Connect.*;



/**
 *
 * @author Bella Belova
 */
public class AddressDB {
    
    public static final String ADDRESS_TABLE_NAME = "3C_ADDRESS";  
    public static java.sql.Connection sqlConn;
    SQL sql_access;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public AddressDB()
    {
        sql_access = new SQL();
        sqlConn = DB_Connection.CommonConnection.getSQLConn();
                
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
            //Create the Address Table
            createString =
            "create table " + ADDRESS_TABLE_NAME + " " + 
            "(ADDRESS_ID integer identity (1,1) NOT NULL, " +
            "CUSTOMER_ID integer NOT NULL, " +
            "ADDRESS_TYPE varchar(10) NOT NULL, " +
            "ADDRESS1 varchar(50) NOT NULL, " +
            "ADDRESS2 varchar(50) NULL, " +
            "CITY varchar(50) NOT NULL, " + 
            "STATE varchar(50) NOT NULL, " + 
            "ZIP integer NOT NULL, " +
            "PRIMARY KEY (ADDRESS_ID), " + 
            "FOREIGN KEY (CUSTOMER_ID) REFERENCES 3C_CUSTOMERS (CUSTOMER_ID)) ";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ADDRESS_TABLE_NAME + "\nDetail: " + e);
        }        
    }

        //Insert AddressDB data
    public void createAddress(int Addr_ID, int Cust_ID, String Addr_Type,
                                        String Addr1, String Addr2, String Addr_City, String Addr_State, int Addr_Zip) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "SET IDENTITY_INSERT " + ADDRESS_TABLE_NAME + " on insert into " + ADDRESS_TABLE_NAME + 
                  " (ADDRESS_ID, CUSTOMER_ID, ADDRESS_TYPE, ADDRESS1, ADDRESS2, "
                  + "CITY, STATE, ZIP) VALUES(" + Addr_ID + ", " + 
                    Cust_ID + ", '" + Addr_Type + "', '" + Addr1 + "', '" + Addr2 + "', '" + 
                    Addr_City + "', '" + Addr_State + "', " + Addr_Zip + ");" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Address in the Database." + "\nDetail: " + e);
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
                results.add(new OrderSystem_Classes.Address (rs.getInt("ADDRESS_ID"), rs.getInt("CUSTOMER_ID"), 
                        rs.getString("ADDRESS_TYPE"), rs.getString("ADDRESS1"), rs.getString("ADDRESS2"), 
                        rs.getString("CITY"), rs.getString("STATE"), rs.getInt("ZIP")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Address Table." + "\nDetail: " + e);
        }
        return results;
    }

     // Query to search for addresses by CUSTOMER_ID
    public static java.util.ArrayList searchAddbyCustomerID(int custID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.AddressDB.ADDRESS_TABLE_NAME + " where CUSTOMER_ID like " + custID + ";" ;                
          stmt = Create_Tables.AddressDB.sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Address (rs.getInt("ADDRESS_ID"), rs.getInt("CUSTOMER_ID"), 
                        rs.getString("ADDRESS_TYPE"), rs.getString("ADDRESS1"), rs.getString("ADDRESS2"), 
                        rs.getString("CITY"), rs.getString("STATE"), rs.getInt("ZIP")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Address Table." + "\nDetail: " + e);
        }
        return results;
    }

    
    
    
    
}
