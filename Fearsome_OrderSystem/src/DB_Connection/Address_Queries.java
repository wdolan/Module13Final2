/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Bella Belova
 */
public class Address_Queries {
    
        public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    // Search table data
    public static java.util.ArrayList searchbyCustomerID(int Customer_ID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Address_Table.ADDRESS_TABLE_NAME + " where CustomerID like " + Customer_ID + ";" ;                
          stmt = Create_Tables.Address_Table.sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Address (rs.getInt("AddressID"), rs.getInt("CustomerID"), 
                        rs.getString("AddressType"), rs.getString("Address1"), rs.getString("Address2"), 
                        rs.getString("City"), rs.getString("State"), rs.getInt("Zip")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Address Table." + "\nDetaill: " + e);
        }
        return results;
    }

    
}
