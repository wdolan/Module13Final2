/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Bella Belova
 */
public class Product_Queries {
    
        public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }

        // Query to search Products database by PROD_ID
     public static java.util.ArrayList searchProductsbyProductID(String prodID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Product_Table.PRODUCT_TABLE_NAME + " where PROD_ID like " + prodID + ";" ;                
          stmt = Create_Tables.Product_Table.mysqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Products (rs.getInt("PROD_ID"), rs.getInt("CATEGORY_ID"), 
                        rs.getString("PROD_NAME"), rs.getString("PROD_DESC"), rs.getInt("PROD_PRICE")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Product ID in Product Table." + "\nDetail: " + e);
        }
        return results;
 }  
        
    public static java.util.ArrayList searchALLProducts()
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Product_Table.PRODUCT_TABLE_NAME + " ;" ;                
          stmt = Create_Tables.Product_Table.mysqlConn.createStatement();
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
