/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

import Connect.*;
import DB_Connection.Product_Queries;


/**
 *
 * @author Bella Belova
 */
public class Product_Table {
    
    public static final String PRODUCT_TABLE_NAME = "3C_PRODUCTS";
    public static java.sql.Connection mysqlConn;
    MYSQL mysql_access;    
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Product_Table()
    {
        mysql_access = new MYSQL();
        mysqlConn = Connect.MYSQL.getMSQLConn();
    }
    
   
        // Drop Table
    
    public void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + PRODUCT_TABLE_NAME + ";";
            stmt = mysqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + PRODUCT_TABLE_NAME + " " + 
            "(PROD_ID integer NOT NULL, " + 
            "CATEGORY_ID integer NOT NULL, " +
            "PROD_NAME varchar(40) NOT NULL, " +
            "PROD_DESC varchar(40) NOT NULL, " +
            "PROD_PRICE float NOT NULL, " + 
            "PRIMARY KEY (PROD_ID), " + 
            "FOREIGN KEY (PROD_ID) REFERENCES 3C_STOCK_ITEMS (PROD_ID))";
            stmt = mysqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + PRODUCT_TABLE_NAME + "\nDetail: " + e);
        }        
    }

            //Insert Items data
    public void createOrder(int Prod_ID, int Categ_ID, String Prod_Name, String Prod_Desc, float Prod_Price) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "insert into " + PRODUCT_TABLE_NAME + 
                  " (PROD_ID, CATEGORY_ID, PROD_NAME, PROD_DESC, PROD_PRICE ) VALUES(" + Prod_ID + ", " + 
                  Categ_ID + ", '" + Prod_Name + "', '" + Prod_Desc  + "', " + Prod_Price + " );" ;
          stmt = mysqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Order in the Database." + "\nDetail: " + e);
        }
    }
    
        public  java.util.ArrayList getAllProducts()
            throws Product_Queries.TableException, TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + PRODUCT_TABLE_NAME + " ;" ;                
          stmt = mysqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Products (rs.getInt("PROD_ID"), rs.getInt("CATEGORY_ID"), 
                        rs.getString("PROD_NAME"), rs.getString("PROD_DESC"), rs.getInt("PROD_PRICE")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Product Table." + "\nDetail: " + e);
        }
        return results;        
    }


}
