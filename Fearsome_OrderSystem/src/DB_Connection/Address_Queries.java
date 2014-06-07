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
    
    // Query to search for addresses by CUSTOMER_ID
    public static java.util.ArrayList searchAddbyCustomerID(int custID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Address_Table.ADDRESS_TABLE_NAME + " where CUSTOMER_ID like " + custID + ";" ;                
          stmt = Create_Tables.Address_Table.sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Address (rs.getInt("ADDRESS_ID"), rs.getInt("CUSTOMER_ID"), 
                        rs.getString("ADDRESS_TYPE"), rs.getString("ADDRESS1"), rs.getString("ADDRESS2"), 
                        rs.getString("CITY"), rs.getString("STATE"), rs.getInt("ZIP")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Address Table." + "\nDetail: " + e);
        }
        return results;
    }

    
}
