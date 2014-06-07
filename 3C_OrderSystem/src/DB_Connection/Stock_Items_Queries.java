/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Bella Belova
 */
public class Stock_Items_Queries {
    
        public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }

    public static java.util.ArrayList searchQTY(int PROD_ID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Stock_Items_Table.STOCK_ITEMS_TABLE_NAME + " where PROD_ID " + PROD_ID + ";" ;                
          stmt = Create_Tables.Stock_Items_Table.mysqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Stock_Items (rs.getInt("PROD_ID"), rs.getString("PROD_NAME"), 
                        rs.getInt("STOCK_QTY")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Quantity in Stock_Items Table." + "\nDetail: " + e);
        }
        return results;
    }

    
}
