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
    // Search table data
    public static java.util.ArrayList searchbyItemID(int Item_ID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Items_Table.ITEMS_TABLE_NAME + " where Order_Item_ID like " + Item_ID + ";" ;                
          stmt = Create_Tables.Items_Table.sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Items (rs.getInt("Order_Item_ID"), rs.getInt("OrderID"), 
                        rs.getInt("ProductID"), rs.getInt("Quantity")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Item Database." + "\nDetail: " + e);
        }
        return results;
    
        }
      
}
