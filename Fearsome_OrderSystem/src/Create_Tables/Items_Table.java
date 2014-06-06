/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

import Connect.*;
import DB_Connection.Item_Queries;

/**
 *
 * @author Bella Belova
 */
public class Items_Table {
    
    public static final String ITEMS_TABLE_NAME = "FEFO_ITEMS";   
    public static java.sql.Connection sqlConn;
    SQL sql_access;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Items_Table()
    {
        sql_access = new SQL();
        sqlConn = Connect.SQL.getSQLConn();
    }
    
    // Drop Table
    
    public void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + ITEMS_TABLE_NAME + ";";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the Items_Table Table
            createString =
            "create table " + ITEMS_TABLE_NAME + " " + 
            "(OrderItemID integer identity (1,1) NOT NULL, " +
            "OrderID integer NOT NULL, " +
            "ProductID integer NOT NULL, " +
            "Quantaty integer NOT NULL, " +
            "PRIMARY KEY (OrderItemID), " +
            "FOREIGN KEY (OrderID) REFERENCES FEFO_ORDERS (OrderID)) ";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ITEMS_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

    
        //Insert Items_Table data
    public void createItems(int Ord_Item_ID, int Ord_ID, int Prod_ID, int QTY) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "SET IDENTITY_INSERT " + ITEMS_TABLE_NAME + " on insert into " + ITEMS_TABLE_NAME + 
                  " (OrderItemID, OrderID, ProductID, Quantaty ) VALUES(" + Ord_Item_ID + ", "
                   + Ord_ID + ", " + Prod_ID + ", " + QTY  + " );" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Address in the Database." + "\nDetaill: " + e);
        }
    }
    
        public static java.util.ArrayList getAllItems()
            throws Item_Queries.TableException, TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + ITEMS_TABLE_NAME + ";" ;                
          stmt = sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Items (rs.getInt("Order_Item_ID"), rs.getInt("OrderID"), 
                        rs.getInt("ProductID"), rs.getInt("Quantaty")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Item Database." + "\nDetaill: " + e);
        }
        return results;
    
        }

}


    
    
    
