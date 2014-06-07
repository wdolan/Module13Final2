/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

import Connect.*;
import DB_Connection.Order_Queries;

/**
 *
 * @author Gregory
 */
public class Orders_Table {
    
    public static final String ORDERS_TABLE_NAME = "3C_ORDERS";   
    public static java.sql.Connection sqlConn;
    SQL sql_access;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Orders_Table()
    {
        sql_access = new SQL();
        sqlConn = Connect.SQL.getSQLConn();
    }
    
    // Drop Table
    
    public void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + ORDERS_TABLE_NAME + ";";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + ORDERS_TABLE_NAME + " " + 
            "(ORDER_ID integer identity (1,1) NOT NULL, " +
            "CUSTOMER_ID integer NOT NULL, " +
            "FINANCIAL varchar(50) NULL, " +
            "ORDER_DATE DATE NULL, " +
            "PRIMARY KEY (ORDER_ID))";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ORDERS_TABLE_NAME + "\nDetail: " + e);
        }        
    }

            //Insert Items data
    public void createOrder(int Ord_ID, int Cust_ID, String Fin, String Ord_Date) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "SET IDENTITY_INSERT " + ORDERS_TABLE_NAME + " on insert into " + ORDERS_TABLE_NAME + 
                  " (ORDER_ID, CUSTOMER_ID, FINANCIAL, ORDER_DATE ) VALUES(" + Ord_ID + ", "
                   + Cust_ID + ", '" + Fin + "', '" + Ord_Date  + "' );" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Order in the Database." + "\nDetail: " + e);
        }
    }
    
        public static java.util.ArrayList getAllOrders()
            throws Order_Queries.TableException, TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + ORDERS_TABLE_NAME + ";" ;                
          stmt = sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Orders (rs.getInt("ORDER_ID"), rs.getInt("CUSTOMER_ID"), 
                        rs.getString("FINANCIAL"), rs.getString("ORDER_DATE")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Order Database." + "\nDetail: " + e);
        }
        return results;
    }    
}
