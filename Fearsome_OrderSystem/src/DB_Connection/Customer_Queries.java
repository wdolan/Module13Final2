/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Bella Belova
 */
public class Customer_Queries {
        public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }

    // Query to search for a Customer by their LAST_NAME
    public static java.util.ArrayList searchCustbyLastName(String lName)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + Create_Tables.Customer_Table.CUSTOMER_TABLE_NAME + " where LAST_NAME like '%" + lName + "%';" ;                
          stmt = Create_Tables.Customer_Table.sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Customer (rs.getInt("CUSTOMER_ID"), rs.getString("FIRST_NAME"), 
                        rs.getString("LAST_NAME"), rs.getInt("BILL_ADDRESS"), rs.getInt("SHIP_ADDRESS"), 
                        rs.getString("EMAIL"), rs.getString("PHONE")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Customer Table." + "\nDetail: " + e);
        }
        return results;
    }
}
