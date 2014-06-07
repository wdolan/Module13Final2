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
    
        // Query to search orders by the ORDER_ID
    public static java.util.ArrayList searchOrdersbyOrderID(int orderID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Orders_Table.ORDERS_TABLE_NAME + " where ORDER_ID like " + orderID + ";" ;                
          stmt = Create_Tables.Orders_Table.sqlConn.createStatement();
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
