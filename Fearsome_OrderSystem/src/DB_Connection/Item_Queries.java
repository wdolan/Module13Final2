/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;


/**
 *
 * @author Bella Belova
 */
public class Item_Queries {
        public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
     }    
    // Query to search for Items by ITEM_ID
    public static java.util.ArrayList searchItemsbyItemID(int itemID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Items_Table.ITEMS_TABLE_NAME + " where ORDER_ITEM_ID like " + itemID + ";" ;                
          stmt = Create_Tables.Items_Table.sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.OrderItems (rs.getInt("ORDER_ITEM_ID"), rs.getInt("ORDER_ID"), 
                        rs.getInt("PRODUCT_ID"), rs.getInt("QUANTITY"), rs.getFloat("PROD_PRICE")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Item Database." + "\nDetail: " + e);
        }
        return results;
    
        }
      
}
