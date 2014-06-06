/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Msg_Displays;

/**
 *
 * @author Gregory
 */

public class Menu_Item_List {
    
    private static final String PRODUCT_TABLE_NAME = "FEARSOME_PRODUCT";  
    private static java.sql.Connection sqlConn;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }

    public Menu_Item_List()
    {
        sqlConn = Connect.MYSQL.getMSQLConn();
    }
    
    public static java.util.ArrayList Item_List()
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + PRODUCT_TABLE_NAME ;                
          stmt = sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Customer (rs.getInt("CustomerID"), rs.getString("FirstName"), 
                        rs.getString("LastName"), rs.getInt("BillAddress"), rs.getInt("ShipAddress"), 
                        rs.getString("EmailAddress"), rs.getString("PhoneNumber"), rs.getInt("OrderIDs")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to Display Items." + "\nDetaill: " + e);
        }
        return results;
    }


    
}
