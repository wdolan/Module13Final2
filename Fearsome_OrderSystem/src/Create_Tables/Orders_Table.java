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
    
    public static final String ORDERS_TABLE_NAME = "FEFO_ORDERS";   
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
            "(OrderID integer identity (1,1) NOT NULL, " +
            "CustomerID integer NOT NULL, " +
            "Financial varchar(50) NULL, " +
            "OrderDate DATE NULL, " +
            "PRIMARY KEY (OrderID))";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ORDERS_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

            //Insert Items data
    public void createOrder(int Ord_ID, int Cust_ID, String Fin, String Ord_Date) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "SET IDENTITY_INSERT " + ORDERS_TABLE_NAME + " on insert into " + ORDERS_TABLE_NAME + 
                  " (OrderID, CustomerID, Financial, OrderDate ) VALUES(" + Ord_ID + ", "
                   + Cust_ID + ", '" + Fin + "', '" + Ord_Date  + "' );" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Order in the Database." + "\nDetaill: " + e);
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
                results.add(new OrderSystem_Classes.Orders (rs.getInt("Order_ID"), rs.getInt("CustomerID"), 
                        rs.getString("Financial"), rs.getString("OrderDate")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Order Database." + "\nDetaill: " + e);
        }
        return results;
    }    
}
