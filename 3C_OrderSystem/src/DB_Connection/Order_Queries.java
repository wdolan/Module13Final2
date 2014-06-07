/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;


/**
 *
 * @author Bella Belova
 */
public class Order_Queries {
    
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
        // Search table data
    public static java.util.ArrayList searchbyOrder(int Order_ID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Orders_Table.ORDERS_TABLE_NAME + " where OrderID like " + Order_ID + ";" ;                
          stmt = Create_Tables.Orders_Table.sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Orders (rs.getInt("Order_ID"), rs.getInt("CustomerID"), 
                        rs.getString("Financial"), rs.getString("OrderDate")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Order Database." + "\nDetail: " + e);
        }
        return results;
    }

}
